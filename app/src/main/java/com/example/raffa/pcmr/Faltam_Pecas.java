package com.example.raffa.pcmr;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.sql.SQLOutput;

public class Faltam_Pecas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faltam__pecas);
    }
    protected void chamaListaPc(View view){

        //Mensagem 'Salvo com Sucesso!'
        Context context = getApplicationContext();

        DataBaseHelper myDbHelper = new DataBaseHelper(this);

        try {
            myDbHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        try {
            myDbHelper.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }
        CharSequence mensagem = "Salvo com sucesso!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context,mensagem, duration);
        toast.show();
        Intent listaComputadores = new Intent(this, Lista_Computadores.class);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String processador = preferences.getString("pecaprocessador","");
        String placa_mae = preferences.getString("pecaplaca_mae","");
        String hd = preferences.getString("pecahd","");
        String ssd = preferences.getString("pecassd","");
        String ram = preferences.getString("pecaram","");
        String gabinete = preferences.getString("pecagabinete","");
        String fonte = preferences.getString("pecafonte","");
        String placa_video = preferences.getString("pecaplaca_video","");
        String cooler_processador = preferences.getString("pecacooler_processador","");
        String nomePcS = preferences.getString("nomePC","");
        System.out.println(nomePcS);
        myDbHelper.inserePc(nomePcS,processador,placa_mae,hd,ssd,ram,gabinete,fonte,placa_video,cooler_processador);


        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("pecaprocessador","");
        editor.putString("pecaplaca_mae","");
        editor.putString("pecahd","");
        editor.putString("pecassd","");
        editor.putString("pecaram","");
        editor.putString("pecagabinete","");
        editor.putString("pecafonte","");
        editor.putString("pecaplaca_video","");
        editor.putString("pecacooler_processador","");
        editor.putString("nomePC","");
        editor.apply();
        startActivity(listaComputadores);
    }
    protected void voltaMontagem(View view){
        Intent voltaMontagem = new Intent(this, Montando_PC.class);
        startActivity(voltaMontagem);
    }
}
