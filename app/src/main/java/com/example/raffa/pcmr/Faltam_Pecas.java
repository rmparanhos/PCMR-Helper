package com.example.raffa.pcmr;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Faltam_Pecas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faltam__pecas);
    }
    protected void chamaListaPc(View view){

        //Mensagem 'Salvo com Sucesso!'
        Context context = getApplicationContext();
        CharSequence mensagem = "Salvo com sucesso!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context,mensagem, duration);
        toast.show();
        Intent listaComputadores = new Intent(this, Lista_Computadores.class);
        startActivity(listaComputadores);
    }
    protected void voltaMontagem(View view){
        Intent voltaMontagem = new Intent(this, Montando_PC.class);
        startActivity(voltaMontagem);
    }
}
