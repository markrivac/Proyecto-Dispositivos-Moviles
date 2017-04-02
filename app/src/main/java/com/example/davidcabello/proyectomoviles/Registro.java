package com.example.davidcabello.proyectomoviles;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Registro extends AppCompatActivity implements View.OnClickListener {


    EditText e5;
    EditText e6;
    Button b6;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();

        e5 = (EditText) findViewById(R.id.editText5);
        e6 = (EditText) findViewById(R.id.editText6);
        b6 = (Button) findViewById(R.id.button6);
        b6.setOnClickListener(this);
    }

    public void registerUser(){
        String email = e5.getText().toString().trim();
        String password = e6.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
            return;

        }

        if(TextUtils.isEmpty(password)){

            Toast.makeText(this, "Please enter enter password", Toast.LENGTH_SHORT).show();
            return;

        }

        progressDialog.setMessage("Registering User...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            finish();
                            startActivity(new Intent(getApplicationContext(), InicioUser.class));
                            Toast.makeText(Registro.this, "Registered successfully", Toast.LENGTH_SHORT).show();

                        }else{
                            Toast.makeText(Registro.this, "Failed to register", Toast.LENGTH_SHORT).show();

                        }
                        progressDialog.dismiss();
                    }
                });



    }

    @Override
    public void onClick(View v) {

        if (v == b6){
            registerUser();
            e5.setText("");
            e6.setText("");
        }

    }


}
