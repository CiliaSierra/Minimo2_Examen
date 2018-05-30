package com.example.cilia.minimo2_examen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class BookInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_info);

        Intent intent = this.getIntent();
        TextView autor = (TextView) findViewById(R.id.autor);
        autor.setText("Autor: " +intent.getStringExtra("author"));
        TextView titulo = (TextView) findViewById(R.id.titulo);
        titulo.setText("Titulo: " +intent.getStringExtra("title"));
        TextView publicacion = (TextView) findViewById(R.id.publicacion);
        autor.setText("Publicacion: " +intent.getStringExtra("publisher"));
        TextView fecha = (TextView) findViewById(R.id.fecha);
        autor.setText("Fecha: " +intent.getStringExtra("date"));
        TextView descripcion = (TextView) findViewById(R.id.descripcion);
        autor.setText("Descripcion: " +intent.getStringExtra("description"));
        TextView comentarios= (TextView) findViewById(R.id.comentarios);
        autor.setText("Comentarios: " +intent.getStringExtra("comments"));
        Picasso.with(this).load(intent.getStringExtra("image")).into((ImageView) findViewById(R.id.imagen));
    }
}
