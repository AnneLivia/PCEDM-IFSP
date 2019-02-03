//******************************************************

//Instituto Federal de São Paulo - Campus Sertãozinho

//Disciplina......: M4DADM

//Programação de Computadores e Dispositivos Móveis

//Aluna...........: Anne Livia da Fonseca Macedo

//******************************************************

package com.example.annel.projetofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btinserir; // Botão que irá interagir com o arquivo xml

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btinserir = (Button) findViewById(R.id.btinserir); // vinculando o btinserir com o btinserir do arquivo java


        btinserir.setOnClickListener(new View.OnClickListener(){ // Ao clicar no botão
            @Override
            public void onClick(View v)
            {
                trocarTela(); // Será chamada a função de trocar a tela
            }
        });
    }

    // Função utilizada para fazer a troca de activities
    void trocarTela()
    {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, SecondActivity.class); // Indo da primeira activity para a segunda activity
        startActivity(intent); // Ao mudar o intent, inicia-se a activity que foi recebida
        finish();
    }
}
