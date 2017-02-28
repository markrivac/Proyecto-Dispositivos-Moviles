package com.example.davidcabello.proyectomoviles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Categoria extends AppCompatActivity {

    TextView pregunta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        pregunta = (TextView)findViewById(R.id.pregunta);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);

        /*pregunta.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(this, Pregunta.class);
                startActivity(intent);
            }
        });*/
    }
}
