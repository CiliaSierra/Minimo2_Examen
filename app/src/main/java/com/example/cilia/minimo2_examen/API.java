package com.example.cilia.minimo2_examen;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

//CONEXION
public class API {
    private static API instance;

    private static final String baseUrl ="http://api.dsamola.tk/";
    public static APII apii;

    private API(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apii = retrofit.create(APII.class);
    };

    public static API getInstance(){
        if(instance==null)
            return new API();
        return instance;
    }

}
