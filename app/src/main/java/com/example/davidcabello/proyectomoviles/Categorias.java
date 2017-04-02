package com.example.davidcabello.proyectomoviles;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Categorias extends AppCompatActivity {

    ImageButton algorithms;
    ImageButton dataBase;
    ImageButton networks;
    ImageButton videoGames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        algorithms = (ImageButton)findViewById(R.id.algor);
        dataBase = (ImageButton)findViewById(R.id.datab);
        networks = (ImageButton)findViewById(R.id.network);
        videoGames = (ImageButton)findViewById(R.id.videoG);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);
    }

    public void goToAlgorithms(View v){
        Intent intent = new Intent(this, Categoria.class);
        intent.putExtra("CATEGORY","algoritmos");
        startActivity(intent);
    }

    public void goToDatabase(View v){
        Intent intent = new Intent(this, Categoria.class);
        intent.putExtra("CATEGORY","bases");
        startActivity(intent);
    }

    public void goToNetworks(View v){
        Intent intent = new Intent(this, Categoria.class);
        intent.putExtra("CATEGORY","redes");
        startActivity(intent);
    }

    public void goToVideoGames(View v){
        Intent intent = new Intent(this, Categoria.class);
        intent.putExtra("CATEGORY","videojuegos");
        startActivity(intent);
    }
}