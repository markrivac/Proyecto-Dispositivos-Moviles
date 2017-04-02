package com.example.davidcabello.proyectomoviles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Inicio extends AppCompatActivity {

    TextView t1;
    Button b1;
    Button b2;
    Button b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        t1 = (TextView) findViewById(R.id.textView);
<<<<<<< HEAD
=======
        e1 = (EditText) findViewById(R.id.editText);
>>>>>>> 6e522aa30473121a0190f3a11cbca36fe6878d27
        b1 = (Button) findViewById(R.id.buttonLO);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.buttonCat);

    }

    public void GotoLogin(View v){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void GotoRegister(View v){
        Intent intent2 = new Intent(this, Registro.class);
        startActivity(intent2);
    }

    public void GotoCategories(View v){
        Intent intent4 = new Intent(this, Categorias.class);
        startActivity(intent4);
    }

}
