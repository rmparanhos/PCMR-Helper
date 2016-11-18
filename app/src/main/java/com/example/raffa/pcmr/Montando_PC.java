package com.example.raffa.pcmr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Montando_PC extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "";
    public static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_montando__pc);
    }

    protected void chamaMeuPc(View view){
        Intent meuPc = new Intent(this, Meu_PC.class);
        startActivity(meuPc);
    }

    protected void chamaProcessador(View view){
        Intent processador = new Intent(this, Peca_Geral.class);
        String message = "Processador";
        processador.putExtra(EXTRA_MESSAGE, message);
        startActivity(processador);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("NomeTabela","processador");
        editor.apply();
    }

    protected void chamaPlacaMae(View view){
        Intent placaMae = new Intent(this, Peca_Geral.class);
        //pecas diferentes, chamam a mesma activity com outras informçoes
        String message = "Placa Mae";
        placaMae.putExtra(EXTRA_MESSAGE, message);
        startActivity(placaMae);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("NomeTabela","placa_mae");
        editor.apply();
    }

    protected void chamaHD(View view){
        Intent hd = new Intent(this, Peca_Geral.class);
        //pecas diferentes, chamam a mesma activity com outras informçoes
        String message = "HD";
        hd.putExtra(EXTRA_MESSAGE, message);
        startActivity(hd);
    }

    protected void chamaSSD(View view){
        Intent ssd = new Intent(this, Peca_Geral.class);
        //pecas diferentes, chamam a mesma activity com outras informçoes
        String message = "SSD";
        ssd.putExtra(EXTRA_MESSAGE, message);
        startActivity(ssd);
    }

    protected void chamaRAM(View view){
        Intent ram = new Intent(this, Peca_Geral.class);
        //pecas diferentes, chamam a mesma activity com outras informçoes
        String message = "RAM";
        ram.putExtra(EXTRA_MESSAGE, message);
        startActivity(ram);
    }

    protected void chamaGabinete(View view){
        Intent gabinete = new Intent(this, Peca_Geral.class);
        //pecas diferentes, chamam a mesma activity com outras informçoes
        String message = "Gabinete";
        gabinete.putExtra(EXTRA_MESSAGE, message);
        startActivity(gabinete);
    }

    protected void chamaFonte(View view){
        Intent fonte = new Intent(this, Peca_Geral.class);
        //pecas diferentes, chamam a mesma activity com outras informçoes
        String message = "Fonte";
        fonte.putExtra(EXTRA_MESSAGE, message);
        startActivity(fonte);
    }

    protected void chamaPlacaVideo(View view){
        Intent placaVideo = new Intent(this, Peca_Geral.class);
        //pecas diferentes, chamam a mesma activity com outras informçoes
        String message = "Placa de Video";
        placaVideo.putExtra(EXTRA_MESSAGE, message);
        startActivity(placaVideo);
    }

    protected void chamaCoolerProc(View view){
        Intent coolerProc = new Intent(this, Peca_Geral.class);
        //pecas diferentes, chamam a mesma activity com outras informçoes
        String message = "Cooler do Processador";
        coolerProc.putExtra(EXTRA_MESSAGE, message);
        startActivity(coolerProc);
    }
}
