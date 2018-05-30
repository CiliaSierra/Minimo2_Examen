package com.example.cilia.minimo2_examen;

import android.content.Intent;
import android.os.CancellationSignal;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //click en la lista
        ListView listView =(ListView)findViewById(R.id.listaBook);       //lamada a la Api de litado de libros

        API.getInstance().apii.getListBook().enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                if (response.isSuccessful()){

                    List<Book> listabooks = response.body();
                    ListView listView =(ListView)findViewById(R.id.listaBook);
                    BookListAdapter adapter = new BookListAdapter(getApplicationContext(),listabooks);
                    listView.setAdapter(adapter);
                    Toast.makeText(getApplicationContext(), "Se ha conectado", Toast.LENGTH_SHORT).show();
                    ProgressBar pb = (ProgressBar)findViewById(R.id.progressBar);
                    pb.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "No hay conexion con la API", Toast.LENGTH_SHORT).show();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String selesctedItem = (String) parent.getItemAtPosition(position);
                //metodo par acceder a la informacion expezifica de los libros
                getBookInfo(view,position);
            }
        });

    }


    public void getBookInfo(View view,int position ){
        Book book = new Book();
        book.getBook(position);
        API.getInstance().apii.getBook(book.getId()).enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {
            Intent intent = new Intent(getApplicationContext(), BookInfo.class);
            Book book = (Book) response.body();
            //autor, titulo descripcion publicacion fecha imagen comentarios,id
            intent.putExtra("author", book.getAutor());
            intent.putExtra("title", book.getTitulo());
            intent.putExtra("description",book.getDescripcion());
            intent.putExtra("publisher", book.getPublicacion());
            intent.putExtra("date", book.getFecha());
            intent.putExtra("image",book.getImagen());
            intent.putExtra("comments", book.getComentarios());
            intent.putExtra("_id", book.getId());
            startActivity(intent);
            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "No se ha encontrado informacion del libro", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
