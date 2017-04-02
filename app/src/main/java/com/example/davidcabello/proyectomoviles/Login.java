package com.example.davidcabello.proyectomoviles;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

import butterknife.Bind;

public class Login extends AppCompatActivity implements View.OnClickListener {


    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Bind(R.id.editText2) EditText e2;
    @Bind(R.id.editText3) EditText e3;
    @Bind(R.id.button5) Button b5;
    @Bind(R.id.link_signup) TextView _signupLink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        e2 = (EditText) findViewById(R.id.editText2);
        e3 = (EditText) findViewById(R.id.editText3);
        b5 = (Button) findViewById(R.id.button5);
        b5.setOnClickListener(this);

        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(getApplicationContext(), InicioUser.class));

        }

    }

    public void userLogin(){

        String email = e2.getText().toString().trim();
        String password = e3.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
            return;

        }

        if(TextUtils.isEmpty(password)){

            Toast.makeText(this, "Please enter enter password", Toast.LENGTH_SHORT).show();
            return;

        }

        progressDialog.setMessage("Login in please wait...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            progressDialog.dismiss();
                            finish();
                            startActivity(new Intent(getApplicationContext(), InicioUser.class));
                        }
                    }
                });


    }

    @Override
    public void onClick(View v) {

        if (v == b5){
            userLogin();
            Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show();
            e2.setText("");
            e3.setText("");
        }

    }



}
