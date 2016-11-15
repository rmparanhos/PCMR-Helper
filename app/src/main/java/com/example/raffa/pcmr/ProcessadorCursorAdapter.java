package com.example.raffa.pcmr;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by raffa on 15/11/2016.
 */
public class ProcessadorCursorAdapter extends CursorAdapter {
    public ProcessadorCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    // The newView method is used to inflate a new view and return it,
    // you don't bind any data to the view at this point.
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.activity_peca__geral, parent, false);
    }

    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find fields to populate in inflated template
        TextView tvNome = (TextView) view.findViewById(R.id.tvNome);
        TextView tvNucleos = (TextView) view.findViewById(R.id.tvNucleos);
        TextView tvThreads = (TextView) view.findViewById(R.id.tvThread);
        TextView tvFrequencia = (TextView) view.findViewById(R.id.tvFrequencia);
        TextView tvSocket = (TextView) view.findViewById(R.id.tvSocket);
        // Extract properties from cursor
        String nome = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
        int nucleos = cursor.getInt(cursor.getColumnIndexOrThrow("n_nucleos"));
        int threads = cursor.getInt(cursor.getColumnIndexOrThrow("n_threads"));
        float frequencia = cursor.getFloat(cursor.getColumnIndexOrThrow("frequencia"));
        String socket = cursor.getString(cursor.getColumnIndexOrThrow("socket"));
        // Populate fields with extracted properties
        tvNome.setText(nome);
        tvNucleos.setText(String.valueOf(nucleos));
        tvThreads.setText(String.valueOf(threads));
        tvFrequencia.setText(String.valueOf(frequencia));
        tvSocket.setText(socket);
    }
}