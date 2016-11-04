package com.example.raffa.pcmr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Novo_Computador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo__computador);
    }

    protected void chamaMontandoTrab(View view){
        Intent montandoTrab = new Intent(this, Montando_PC.class);
        startActivity(montandoTrab);
    }
    protected void chamaMontandoJogos(View view){
        Intent montandoJogos = new Intent(this, Montando_PC.class);
        startActivity(montandoJogos);
    }
    protected void chamaMontandoGeral(View view){
        Intent montandoGeral = new Intent(this, Montando_PC.class);
        startActivity(montandoGeral);
    }
}
