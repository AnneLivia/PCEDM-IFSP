package com.example.annel.appbancodedados;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DbHelper db;
    EditText etNome, etEndereco, etEmpresa;
    Button btInserir, btListar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.db = new DbHelper(this);
        etNome = (EditText) findViewById(R.id.etNome);
        etEmpresa = (EditText) findViewById(R.id.etEmpresa);
        etEndereco = (EditText) findViewById(R.id.etEndereco);

        btInserir = (Button) findViewById(R.id.btInserir);
        btListar = (Button) findViewById(R.id.btListar);

        btInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etNome.getText().length() > 0 && etEndereco.getText().length() > 0 && etEmpresa.getText().length() > 0) {
                    db.insert(etNome.getText().toString(), etEndereco.getText().toString(), etEmpresa.getText().toString());
                    AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                    adb.setTitle("Sucesso");
                    adb.setMessage("Cadastro Realizado");
                    adb.show();

                    etEmpresa.setText("");
                    etEndereco.setText("");
                    etNome.setText("");
                } else {
                    AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                    adb.setTitle("Erro");
                    adb.setMessage("Todos os campos devem ser preenchidos");
                    adb.show();

                    etEmpresa.setText("");
                    etEndereco.setText("");
                    etNome.setText("");
                }
            }
        });

        btListar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                List<Contato> contatos = db.queryGetAll();
                if(contatos == null)
                {
                    AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                    adb.setTitle("Mensagem");
                    adb.setMessage("Não há registros cadastrados");
                    adb.show();

                    etEmpresa.setText("");
                    etEndereco.setText("");
                    etNome.setText("");
                    return;
                }

                for(int i = 0; i < contatos.size(); i++)
                {
                    Contato contato = (Contato) contatos.get(i);
                    AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                    adb.setTitle("Registro" + i);
                    adb.setMessage("Nome: " + contato.getNome() + "\nEndereco: "+ contato.getEndereco()+"\nEmpresa: "+contato.getEmpresa());
                    adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    adb.show();
                }
            }
        });
    }
}
