package com.example.davidcabello.proyectomoviles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Categoria extends AppCompatActivity {

    TextView pregunta;
    final FirebaseDatabase database = FirebaseDatabase.getInstance().addValueEventListener();
    private FirebaseAuth firebaseAuth;
    private DatabaseReference ref;
    private DatabaseReference questionRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        pregunta = (TextView)findViewById(R.id.pregunta);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);

        pregunta.setText();
    }
/*
    public void goToQuestion(View v){
        Intent intent = new Intent(this, Pregunta.class);
        startActivity(intent);
    }
*/
}
