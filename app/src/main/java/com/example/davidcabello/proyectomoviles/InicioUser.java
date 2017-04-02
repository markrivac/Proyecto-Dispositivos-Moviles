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
<<<<<<< HEAD
import android.widget.ListView;
=======
>>>>>>> 6e522aa30473121a0190f3a11cbca36fe6878d27
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
<<<<<<< HEAD
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
=======
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InicioUser extends AppCompatActivity implements View.OnClickListener{

    Button preguntarB, logOutB, categoriasB, userB;
    EditText preguntaEt, categEt;
>>>>>>> 6e522aa30473121a0190f3a11cbca36fe6878d27

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private FirebaseAuth firebaseAuth;
    private DatabaseReference ref;
    private DatabaseReference questionRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciouser);

<<<<<<< HEAD
        final ArrayList<String> questionList = new ArrayList<String>();

=======
>>>>>>> 6e522aa30473121a0190f3a11cbca36fe6878d27
        preguntarB = (Button)findViewById(R.id.butPregunta);
        preguntarB.setOnClickListener(this);
        logOutB = (Button)findViewById(R.id.buttonLO);
        logOutB.setOnClickListener(this);
        categoriasB = (Button)findViewById(R.id.buttonCat);
        userB = (Button)findViewById(R.id.buttonUser);
        preguntaEt = (EditText)findViewById(R.id.eTPregunta);
        categEt = (EditText)findViewById(R.id.eTCategory);
<<<<<<< HEAD
        listView = (ListView)findViewById(R.id.listView_Questions);

        this.ref = database.getReferenceFromUrl("https://appmoviles-c9f82.firebaseio.com/Questions");
=======

        this.ref = database.getReference("https://appmoviles-c9f82");
        this.questionRef = ref.child("Questions");
>>>>>>> 6e522aa30473121a0190f3a11cbca36fe6878d27
        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth == null){
            finish();
            startActivity(new Intent(this, Login.class));
        }
<<<<<<< HEAD

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

=======
    }

>>>>>>> 6e522aa30473121a0190f3a11cbca36fe6878d27
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
<<<<<<< HEAD

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
=======
        String user = firebaseAuth.getCurrentUser().getUid();
        QuestionFB questionFB = new QuestionFB(pregunta, categoria, user);
        questionRef.push().setValue(questionFB);
        Toast.makeText(this, "Pregunta hecha", Toast.LENGTH_SHORT).show();
>>>>>>> 6e522aa30473121a0190f3a11cbca36fe6878d27
    }

    @Override
    public void onClick(View v) {
<<<<<<< HEAD

        if (v == preguntarB) {
            savetoFB();
            preguntaEt.setText("");
            categEt.setText("");
        }

        if(v == logOutB){signOut();}
=======
        if (v == preguntarB){
            savetoFB();
        }else if(v == logOutB){
            signOut();
        }
>>>>>>> 6e522aa30473121a0190f3a11cbca36fe6878d27
    }
}


