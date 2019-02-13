package com.example.annel.blocodenotas;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btCriar;
    EditText etText;
    ListView lvList;

    private ArrayList<String> notes = new ArrayList<String>(); // List that is going to be used in the notes
    ArrayAdapter<String> adapter = null; // Adapter the strings inside the list into the listView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCriar = (Button) findViewById(R.id.btCriar);
        etText = (EditText) findViewById(R.id.etText);
        lvList = (ListView) findViewById(R.id.lvList);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, notes); // instantiating the adapter and putting in the constructor the current activity, the list item and the list Array
        lvList.setAdapter(adapter);

        btCriar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                String textNote = etText.getText().toString();
                if (textNote.length() > 0)
                {
                    etText.setText("");
                    etText.findFocus();
                    notes.add(textNote);
                    adapter.notifyDataSetChanged(); // Modifying the adapter
                }
            }
        });

        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                adb.setTitle("Note");
                adb.setMessage("Do you want to delete this note ?");
                final int positionToRemove = position;
                adb.setNegativeButton("No",null);
                adb.setPositiveButton("Yes", new AlertDialog.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which){
                        notes.remove(positionToRemove);
                        adapter.notifyDataSetChanged();
                    }
                });
                adb.show();
            }
        });
    }
}
