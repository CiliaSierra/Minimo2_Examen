package com.example.cilia.minimo2_examen;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APII {
    @GET("/books/{id}")
    Call<Book> getBook(@Path("id") String id);

    @GET("/books")
    Call<List<Book>> getListBook();
}
