package com.example.annel.appbancodedados;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentNavigableMap;

/**
 * Created by annel on 04/12/2017.
 */
// Classe utilizada para fazer a comunicação com o banco de dados

public class DbHelper {
    // private porque é privado, so está classe tem acesso ao nome do banco de dados
    // static porque ele é o mesmo para todas as classes
    // Esse nome bancodedados não vai mudar
    private static final String DATABASE_NAME = "bancodedados.db"; // Nome do banco de dados
    private static final int DATABASE_VERSION = 1; // Número da versão do banco de dados
    private static final String TABLE_NAME = "contato"; // Nome da tabela do banco de dados

    private Context context;
    private SQLiteDatabase db; // Usa-se ele para se criar suporte ao banco de dados
    private SQLiteStatement insertStat;
    private static final String INSERT = "insert into " + TABLE_NAME + " (nome, endereco, empresa) values (?,?,?)";

    public DbHelper(Context context)
    {
        this.context = context;
        OpenHelper openHelper = new OpenHelper(this.context);
        this.db = openHelper.getWritableDatabase();
        this.insertStat = this.db.compileStatement(INSERT);
    }

    public long insert (String nome, String endereco, String empresa)
    {
        this.insertStat.bindString(1,nome);
        this.insertStat.bindString(2,endereco);
        this.insertStat.bindString(3,empresa);
        return this.insertStat.executeInsert();
    }

    public void deleteAll()
    {
        this.db.delete(TABLE_NAME, null, null);
    }

    public List<Contato> queryGetAll(){
        List <Contato> list = new ArrayList<Contato>();

        try{
            Cursor cursor = this.db.query(TABLE_NAME, new String [] {"Nome","Endereco","Empresa"}, null, null, null, null, null, null);
            int nRegistros = cursor.getCount();
            if(nRegistros != 0)
            {
                cursor.moveToFirst();
                do{
                    Contato contato = new Contato(cursor.getString(0),cursor.getString(1),cursor.getString(2));
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

    private static class OpenHelper extends SQLiteOpenHelper{
        public void onCreate(SQLiteDatabase db)
        {
            String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, endereco TEXT, empresa TEXT);";
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
