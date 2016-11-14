package com.example.raffa.pcmr;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class Peca_Geral extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peca__geral);

        DataBaseHelper myDbHelper = new DataBaseHelper(this);

        try {
            myDbHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        try {
            myDbHelper.openDataBase();
        }catch(SQLException sqle){
            throw sqle;
        };

        /*SQLiteDatabase db = myDbHelper.getReadableDatabase();
        Cursor c = db.query("processador",null,null,null,null,null,null);
        if(c.moveToFirst()){
            System.out.println("null");
        };
        String proc = c.getString(c.getColumnIndex("processador"));
        System.out.println(proc); */
        /*Cursor c = myDbHelper.lerBD("processador");
        c.moveToFirst();
        String proc = c.getString(4);
        Context context = getApplicationContext();
        CharSequence mensagem = proc;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context,mensagem, duration);
        toast.show();*/


        Intent intent = getIntent();
        String message = intent.getStringExtra(Montando_PC.EXTRA_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);
        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_peca__geral);
        layout.addView(textView);

        //Mexendo no Listview

       /* System.out.println("Entered ListViewActivity");

        ArrayList<HashMap<String, String>> Items = new ArrayList<HashMap<String, String>>();

        System.out.println("Arraylist hashmap declared");

        // Reading all values
        Log.d("Reading: ", "Reading all contacts..");

        Cursor c = myDbHelper.lerBD("processador");
        c.moveToFirst();
        do{
            // Writing values to map
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("nome",c.getString(0));
            map.put("nucleos", c.getString(1));
            map.put("threads", c.getString(2));
            map.put("frequencia", c.getString(3));
            map.put("socket", c.getString(4));

            Items.add(map);
        }while(c.moveToNext());

        ListAdapter adapter = new SimpleAdapter(this, Items, R.layout.activity_peca__geral,
                new String[] { "nome", "nucleos", "threads", "frequencia","socket" },
                new int[] {R.id.nome, R.id.time, R.id.capacity, R.id.price });

        setListAdapter(adapter);*/



        // Query for all people contacts using the Contacts.People convenience class.
        // Put a managed wrapper around the retrieved cursor so we don't have to worry about
        // requerying or closing it as the activity changes state.
        Cursor mCursor = myDbHelper.lerBD("processador");
        startManagingCursor(mCursor);

        // Now create a new list adapter bound to the cursor.
        // SimpleListAdapter is designed for binding to a Cursor.
        ListAdapter adapter = new SimpleCursorAdapter(
                this, // Context.
                android.R.layout.two_line_list_item,  // Specify the row template to use (here, two columns bound to the two retrieved cursorrows).
                mCursor,                                              // Pass in the cursor to bind to.
                new String[] {"nome", "nucleos"},           // Array of cursor columns to bind to.
                new int[] {android.R.id.text1, android.R.id.text2});  // Parallel array of which template objects to bind to those columns.

        // Bind to our new adapter.
        setListAdapter(adapter);

    }


}
