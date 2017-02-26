package com.example.davidcabello.proyectomoviles;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Inicio extends AppCompatActivity {

    TextView t1;
    EditText e1;
    Button b1;
    Button b2;
    Button b3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        t1 = (TextView) findViewById(R.id.textView);
        e1 = (EditText) findViewById(R.id.editText);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);


    }


    public void GotoLogin(View v){
        Intent intent = new Intent(this, Login.class);
        startActivityForResult(intent, 0);
    }

    public void GotoRegister(View v){
        Intent intent2 = new Intent(this, Registro.class);
        startActivityForResult(intent2, 0);
    }

    public void GotoCategories(View v){
        Intent intent4 = new Intent(this, Categorias.class);
        startActivityForResult(intent4, 0);
    }

}


