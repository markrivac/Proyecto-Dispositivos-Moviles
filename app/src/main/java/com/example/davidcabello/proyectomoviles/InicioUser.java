package com.example.davidcabello.proyectomoviles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class InicioUser extends AppCompatActivity implements View.OnClickListener{

    Button preguntarB, logOutB, categoriasB, userB;
    EditText preguntaEt, categEt;
    ListView listView;

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private FirebaseAuth firebaseAuth;
    private DatabaseReference ref;
    private DatabaseReference questionRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciouser);

        final ArrayList<String> questionList = new ArrayList<String>();

        preguntarB = (Button)findViewById(R.id.butPregunta);
        preguntarB.setOnClickListener(this);
        logOutB = (Button)findViewById(R.id.buttonLO);
        logOutB.setOnClickListener(this);
        categoriasB = (Button)findViewById(R.id.buttonCat);
        userB = (Button)findViewById(R.id.buttonUser);
        preguntaEt = (EditText)findViewById(R.id.eTPregunta);
        categEt = (EditText)findViewById(R.id.eTCategory);
        listView = (ListView)findViewById(R.id.listView_Questions);

        this.ref = database.getReferenceFromUrl("https://appmoviles-c9f82.firebaseio.com/Questions");
        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth == null){
            finish();
            startActivity(new Intent(this, Login.class));
        }

        this.ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Cada vez que el mensaje cambie, se va a llamar este bloque de codigo

                for (DataSnapshot question : dataSnapshot.getChildren()) {
                    Log.i("question", question.getKey());

                    QuestionFB questionFB = question.getValue(QuestionFB.class);
                    questionList.add(questionFB.getQuestion());
                }

                ArrayAdapter arrayAdapter = new ArrayAdapter(InicioUser.this, android.R.layout.simple_list_item_1, questionList);
                listView.setAdapter(arrayAdapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(InicioUser.this, "The read failed : " + databaseError.getCode(), Toast.LENGTH_LONG).show();
            }
        });

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

        if(TextUtils.isEmpty(pregunta)){
            Toast.makeText(this, "Please enter a question", Toast.LENGTH_SHORT).show();
            return;

        }

        if(TextUtils.isEmpty(categoria)){

            Toast.makeText(this, "Please enter enter the category of your question", Toast.LENGTH_SHORT).show();
            return;

        }

        String user = firebaseAuth.getCurrentUser().getUid();
        questionRef.push().setValue(new QuestionFB(pregunta, categoria, user));
        Toast.makeText(this, "Question submitted", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {

        if (v == preguntarB) {
            savetoFB();
            preguntaEt.setText("");
            categEt.setText("");
        }

        if(v == logOutB){signOut();}
    }
}


