//******************************************************

//Instituto Federal de São Paulo - Campus Sertãozinho

//Disciplina......: M4DADM

//Programação de Computadores e Dispositivos Móveis

//Aluna...........: Anne Livia da Fonseca Macedo

//******************************************************

package com.example.annel.projetofinal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by annel on 09/12/2017.
 */

// Classe criada para fazer a comunicação com o banco de dados.
public class DBhelper {
    // Abaixo segue as declarações dos atributos necessarios para se conectar com o banco de dados
    private static final String DATABASE_NAME = "bancodedados.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "pessoa";

    private Context context;
    private SQLiteDatabase db;
    private SQLiteStatement insertStat;
    private static final String INSERT = "insert into " + TABLE_NAME + " (nome, idade, cpf, telefone, email) values (?,?,?,?,?)";
    // Construtor da classe
    public DBhelper(Context context)
    {
        this.context = context;
        OpenHelper openHelper = new OpenHelper(this.context);
        this.db = openHelper.getWritableDatabase();
        this.insertStat = this.db.compileStatement(INSERT);
    }

    // Função utilizada para realizar a inserção dos dados
    public long insert (String nome, int idade, String cpf, String telefone, String email)
    {
        this.insertStat.bindString(1,nome);
        this.insertStat.bindLong(2,idade);
        this.insertStat.bindString(3,cpf);
        this.insertStat.bindString(4,telefone);
        this.insertStat.bindString(5,email);
        return this.insertStat.executeInsert();
    }

    // Função utilizada para deletar todos os dados armazenados
    public void deleteAll()
    {
        this.db.delete(TABLE_NAME, null, null);
    }
    // Função que retorna uma lista do tipo pessoafisica no qual conterá os valores que já foram armazenados no banco de dados
    public List<PessoaFisica> queryGetAll(){
        List <PessoaFisica> list = new ArrayList<PessoaFisica>();

        try{
            Cursor cursor = this.db.query(TABLE_NAME, new String [] {"Nome","Idade","CPF","Telefone","Email"}, null, null, null, null, null, null);
            int nRegistros = cursor.getCount();
            if(nRegistros != 0)
            {
                cursor.moveToFirst();
                do{
                    PessoaFisica contato = new PessoaFisica(cursor.getString(0),cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));
                    list.add(contato);
                }while(cursor.moveToNext());

                if(cursor != null && !cursor.isClosed())
                    cursor.close();
                return list;
            } else {
                return null;
            }

        } catch (Exception err) {
            return null;
        }
    }
    // Inner class necessaria para criação da tabela.
    private static class OpenHelper extends SQLiteOpenHelper {
        public void onCreate(SQLiteDatabase db)
        {
            String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, idade INTEGER, cpf TEXT, telefone TEXT, email TEXT);";
            db.execSQL(sql);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }

        OpenHelper(Context context)
        {
            super (context,DATABASE_NAME,null,DATABASE_VERSION);
        }
    }

}
