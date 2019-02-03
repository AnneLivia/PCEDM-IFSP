//******************************************************

//Instituto Federal de São Paulo - Campus Sertãozinho

//Disciplina......: M4DADM

//Programação de Computadores e Dispositivos Móveis

//Aluna...........: Anne Livia da Fonseca Macedo

//******************************************************

package com.example.annel.projetofinal;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class SecondActivity extends AppCompatActivity {
    private DBhelper db;

    Button btinserirdados, btvoltar, btlistar;
    EditText etnome, etidade, etcpf, ettelefone, etemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        this.db = new DBhelper(this);
        // Abaixo está sendo realizado a vinculação dos botões e dos edit text do arquivo xml com a classe java.
        btinserirdados = (Button) findViewById(R.id.btinserirdados);
        btlistar = (Button) findViewById(R.id.btlistar);
        btvoltar = (Button) findViewById(R.id.btvoltar);
        etnome = (EditText) findViewById(R.id.etnome);
        etidade = (EditText) findViewById(R.id.etidade);
        etcpf = (EditText) findViewById(R.id.etcpf);
        ettelefone = (EditText) findViewById(R.id.ettelefone);
        etemail = (EditText) findViewById(R.id.etemail);

        // Este botão será utilizado para inserir os valores no banco de dados
        btinserirdados.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                // Abaixo segue uma verificação se todos os espaço tem o tamanho é maior que 0, significando que foi digitado algo.
                if(etnome.getText().length() > 0 && etidade.getText().length() > 0 && etcpf.getText().length() > 0
                        && ettelefone.length() > 0 && etemail.getText().length() > 0) {
                    // O usuário tendo digitado em todos os campos, será utilizado o metodo insert da classe DBHelper, e irá ser inserido todos os dados no banco de dados
                    db.insert(etnome.getText().toString(), Integer.parseInt(etidade.getText().toString()),etcpf.getText().toString(),
                              ettelefone.getText().toString(),etemail.getText().toString());
                    // Abaixo segue a criação de um alert builder para ser mostrado na tela que a inserção de dados foi bem sucedida.
                    AlertDialog.Builder adb = new AlertDialog.Builder(SecondActivity.this);
                    adb.setTitle("Sucesso");
                    adb.setMessage("Pessoa física cadastrada com sucesso!");
                    adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    adb.show();
                    // Abaixo está sendo apagado todos os campos edittext
                    etnome.setText("");
                    etidade.setText("");
                    etcpf.setText("");
                    ettelefone.setText("");
                    etemail.setText("");
                } else { // Caso algum campo esteja vazio, será exibida uma mensagem de erro
                    // Abaixo está sendo criado um alert dialog que exibirá essa informação
                    AlertDialog.Builder adb = new AlertDialog.Builder(SecondActivity.this);
                    adb.setTitle("Erro");
                    adb.setMessage("Todos os campos devem ser preenchidos");
                    adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    adb.show();
                    // Abaixo está sendo apagado todos os campos edittext
                    etnome.setText("");
                    etidade.setText("");
                    etcpf.setText("");
                    ettelefone.setText("");
                    etemail.setText("");
                }
            }
        });

        // Função usada para listar os dados na tela, por meio de um alert dialog assim que o usuário clica no botão
        btlistar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                List<PessoaFisica> pessoa = db.queryGetAll(); //Criação de uma lista do tipo PessoaFisica que irá receber todos os dados armazenados no banco de dados
                if(pessoa == null) // se for igual a null significa que não há nenhum valor armazenado no banco de dados
                {
                    AlertDialog.Builder adb = new AlertDialog.Builder(SecondActivity.this); // Instancia de um alert dialog, para mostrar a mensagem na tela
                    adb.setTitle("Mensagem");
                    adb.setMessage("Não há registros cadastrados");
                    adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    adb.show();
                    // Abaixo está sendo apagado tudo que foi digitados nos campos edit text
                    etnome.setText("");
                    etidade.setText("");
                    etcpf.setText("");
                    etemail.setText("");
                    ettelefone.setText("");
                    return; // Return para finalizar, e sair da função
                }
                // Caso nao tenha sido finalizado a função, então será utilizado um for para ser impresso na tela todos os dados armazenados
                for(int i = 0; i < pessoa.size(); i++)
                {
                    PessoaFisica p = (PessoaFisica) pessoa.get(i);
                    AlertDialog.Builder adb = new AlertDialog.Builder(SecondActivity.this);
                    adb.setTitle("Pessoa Física " + (i + 1));
                    adb.setMessage("Nome: " + p.getNome() + "\nIdade: "+ p.getIdade() +"\nCPF: "+ p.getCpf()+"\nTelefone: "+p.getTelefone()+
                                   "\nEmail: "+p.getEmail());
                    adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    adb.show();
                    // Depois de ter sido apresentado tudo em uma janela do alert builder, a função será finalizada.
                }
            }
        });

        btvoltar.setOnClickListener(new View.OnClickListener(){ // Ao clicar no botão
            @Override
            public void onClick(View v)
            {
                trocarTela();  // Será chamada a função de trocar a tela
            }
        });
    }

    // Função utilizada para fazer a troca de activities
    void trocarTela()
    {
        Intent intent = new Intent();
        intent.setClass(SecondActivity.this, MainActivity.class); // Indo da segunda activity para a primeira (main) activity
        startActivity(intent); // Ao mudar o intent, inicia-se a activity que foi recebida
        finish();
    }
}
