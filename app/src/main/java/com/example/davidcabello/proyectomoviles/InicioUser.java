package com.example.davidcabello.proyectomoviles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InicioUser extends AppCompatActivity implements View.OnClickListener{

    Button preguntarB, logOutB, categoriasB, userB;
    EditText preguntaEt, categEt;

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private FirebaseAuth firebaseAuth;
    private DatabaseReference ref;
    private DatabaseReference questionRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciouser);

        preguntarB = (Button)findViewById(R.id.butPregunta);
        preguntarB.setOnClickListener(this);
        logOutB = (Button)findViewById(R.id.buttonLO);
        logOutB.setOnClickListener(this);
        categoriasB = (Button)findViewById(R.id.buttonCat);
        userB = (Button)findViewById(R.id.buttonUser);
        preguntaEt = (EditText)findViewById(R.id.eTPregunta);
        categEt = (EditText)findViewById(R.id.eTCategory);

        this.ref = database.getReference("https://appmoviles-c9f82");
        this.questionRef = ref.child("Questions");
        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth == null){
            finish();
            startActivity(new Intent(this, Login.class));
        }
    }

    public void GotoUsuario(View v){
        Intent intent3 = new Intent(this, Usuario.class);
        startActivityForResult(intent3, 0);
    }

    public void GotoCategories(View v){
        Intent intent4 = new Intent(this, Categorias.class);
        startActivityForResult(intent4, 0);
    }

    public void signOut() {
        firebaseAuth.signOut();
        Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show();
        finish();
        startActivity(new Intent(this, Inicio.class));
    }

    public void savetoFB(){

        String pregunta = preguntaEt.getText().toString().trim();
        String categoria = categEt.getText().toString().trim();
        String user = firebaseAuth.getCurrentUser().getUid();
        QuestionFB questionFB = new QuestionFB(pregunta, categoria, user);
        questionRef.push().setValue(questionFB);
        Toast.makeText(this, "Pregunta hecha", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        if (v == preguntarB){
            savetoFB();
        }else if(v == logOutB){
            signOut();
        }
    }
}


