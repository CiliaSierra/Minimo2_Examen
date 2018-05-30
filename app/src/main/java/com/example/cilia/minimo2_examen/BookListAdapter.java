package com.example.cilia.minimo2_examen;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.concurrent.TimeoutException;

public class BookListAdapter extends ArrayAdapter<Book> {
    public BookListAdapter(@NonNull Context context, List<Book> resource) {
        super(context, 0,resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Book book = getItem(position);
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_book_list_adapter, parent, false);
        }

        Picasso.with(super.getContext()).load(book.getImagen()).into((ImageView) convertView.findViewById(R.id.imagen));
        TextView autor = (TextView)convertView.findViewById(R.id.autor);
        autor.setText(book.getAutor());
        TextView titulo = (TextView)convertView.findViewById(R.id.titulo);
        titulo.setText(book.getTitulo());
        return convertView;
    }
}
