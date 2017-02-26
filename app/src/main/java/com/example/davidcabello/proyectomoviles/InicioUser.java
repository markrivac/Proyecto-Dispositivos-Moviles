package com.example.davidcabello.proyectomoviles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class InicioUser extends AppCompatActivity implements View.OnClickListener {

    TextView t1;
    EditText e1;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciouser);

        t1 = (TextView) findViewById(R.id.textView);
        e1 = (EditText) findViewById(R.id.editText);
        b1 = (Button) findViewById(R.id.button);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        b1.setOnClickListener(this);
        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth == null){
            finish();
            startActivity(new Intent(this, Login.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();

    }




    public void GotoUsuario(View v){
        Intent intent3 = new Intent(this, Usuario.class);
        startActivityForResult(intent3, 0);
    }

    public void GotoCategories(View v){
        Intent intent4 = new Intent(this, Categorias.class);
        startActivityForResult(intent4, 0);
    }

    @Override
    public void onClick(View v) {

        if (v == b1){
            firebaseAuth.signOut();
            Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show();
            finish();
            startActivity(new Intent(this, Inicio.class));
        }

    }
}


