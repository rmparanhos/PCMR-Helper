package com.example.raffa.pcmr;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class Meu_PC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meu__pc);
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
        TextView textView = (TextView)findViewById(R.id.processadorTV);
        textView.setText(processador);
        TextView textView2 = (TextView)findViewById(R.id.placa_maeTV);
        textView2.setText(placa_mae);
        TextView textView3 = (TextView)findViewById(R.id.hdTV);
        textView3.setText(hd);
        TextView textView4 = (TextView)findViewById(R.id.ssdTV);
        textView4.setText(ssd);
        TextView textView5 = (TextView)findViewById(R.id.ramTV);
        textView5.setText(ram);
        TextView textView6 = (TextView)findViewById(R.id.gabineteTV);
        textView6.setText(gabinete);
        TextView textView7 = (TextView)findViewById(R.id.fonteTV);
        textView7.setText(fonte);
        TextView textView8 = (TextView)findViewById(R.id.placa_videoTV);
        textView8.setText(placa_video);
        TextView textView9 = (TextView)findViewById(R.id.cooler_procTV);
        textView9.setText(cooler_processador);

    }

    protected void chamaVerificar(View view){
        EditText nomePcET = (EditText)findViewById(R.id.editTextNomePC);
        String nomePcS = nomePcET.getText().toString();
        if(!verifyPecas()) {
            Intent faltamPecas = new Intent(this, Faltam_Pecas.class);
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("nomePC",nomePcS);
            editor.apply();
            startActivity(faltamPecas);
        }else{
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
    }

    protected void voltaMontandoPc(View view){
        Intent montandoPc = new Intent(this, Montando_PC.class);
        startActivity(montandoPc);
    }

    protected boolean verifyPecas(){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        if(preferences.getString("pecaprocessador","")=="")return false;
        if(preferences.getString("pecaplaca_mae","")=="")return false;
        if(preferences.getString("pecahd","")=="")return false;
        if(preferences.getString("pecassd","")=="")return false;
        if(preferences.getString("pecaram","")=="")return false;
        if(preferences.getString("pecagabinete","")=="")return false;
        if(preferences.getString("pecafonte","")=="")return false;
        if(preferences.getString("pecaplaca_video","")=="")return false;
        if(preferences.getString("pecacooler_processador","")=="")return false;
        return true;
    }
}
