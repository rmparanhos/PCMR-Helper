package com.example.raffa.pcmr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Lista_Computadores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista__computadores);
    }

    protected void chamaTelaInicial(View view){
        Intent telaInicial = new Intent(this, Tela_Inicial.class);
        startActivity(telaInicial);
    }
}
