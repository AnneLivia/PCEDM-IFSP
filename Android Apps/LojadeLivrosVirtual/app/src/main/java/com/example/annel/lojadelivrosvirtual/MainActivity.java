package com.example.annel.lojadelivrosvirtual;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvMensagem;
    CheckBox cbCSharp, cbJava, cbAndroid;
    Button btComprar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMensagem = (TextView) findViewById(R.id.tvMensagem);
        cbCSharp = (CheckBox) findViewById(R.id.cbCsharp);
        cbJava = (CheckBox) findViewById(R.id.cbJava);
        cbAndroid = (CheckBox) findViewById(R.id.cbAndroid);
        btComprar = (Button) findViewById(R.id.btComprar);

        btComprar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                String mensagem;

                if(!cbJava.isChecked() && !cbCSharp.isChecked() && !cbAndroid.isChecked()){
                    mensagem = "Você não selecionou nenhum livro.\n\n"; // Será usado para colocar as coisas selecionadas
                    AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this); // Fazendo uma instancia de AlertDialog.Builder
                    // E passando como paramatro no construtor a view atual que se chama MainActivity

                    alerta.setMessage(mensagem); // O nome do meu objeto é alerta, e o metodo setMesagem é para colocar a mensagem que é para mostrar
                    alerta.show(); // Agora irá ser mostrado.
                    return;
                }
                mensagem = "Você selecionou os livros: \n\n"; // Será usado para colocar as coisas selecionadas
                if(cbAndroid.isChecked()) // Se estiver selecionado no checkBox
                    mensagem += "Android\n";
                if(cbCSharp.isChecked()) // Se estiver selecionado no checkBox
                    mensagem += "CSharp\n";
                if(cbJava.isChecked())  // Se estiver selecionado no checkBox
                    mensagem += "Java\n";

                // Colocando uma mensagem de alerta na tela

                AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this); // Fazendo uma instancia de AlertDialog.Builder
                                                                                         // E passando como paramatro no construtor a view atual que se chama MainActivity

                alerta.setMessage(mensagem); // O nome do meu objeto é alerta, e o metodo setMesagem é para colocar a mensagem que é para mostrar
                alerta.show(); // Agora irá ser mostrado.

            }
        });
    }
}
