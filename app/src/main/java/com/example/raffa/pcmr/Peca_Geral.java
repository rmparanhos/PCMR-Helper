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
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class Peca_Geral extends AppCompatActivity {

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

        // TodoDatabaseHandler is a SQLiteOpenHelper class connecting to SQLite
        //TodoDatabaseHandler handler = new TodoDatabaseHandler(this);
        // Get access to the underlying writeable database
        //SQLiteDatabase db = handler.getWritableDatabase();
        // Query for items from the database and get a cursor back
        //Cursor todoCursor = db.rawQuery("SELECT  * FROM todo_items", null);
        Cursor c = myDbHelper.lerBD("processador");
        c.moveToFirst();
        // Find ListView to populate
        ListView lvItems = (ListView) findViewById(R.id.listViewPeca_Geral);
        // Setup cursor adapter using cursor from last step
        ProcessadorCursorAdapter procAdapter = new ProcessadorCursorAdapter(this, c);
        // Attach cursor adapter to the ListView
        lvItems.setAdapter(procAdapter);
        // Switch to new cursor and update contents of ListView
        //procAdapter.changeCursor(newCursor);
    }


}
