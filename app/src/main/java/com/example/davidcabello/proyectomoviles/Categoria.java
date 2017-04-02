package com.example.davidcabello.proyectomoviles;

<<<<<<< HEAD
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Categoria extends AppCompatActivity {

    ListView listView;

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);

        listView = (ListView)findViewById(R.id.listView_Categoria);
        final ArrayList<String> questionList = new ArrayList<String>();
        this.mRef = database.getReferenceFromUrl("https://appmoviles-c9f82.firebaseio.com/Questions");

        this.mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Cada vez que el mensaje cambie, se va a llamar este bloque de codigo

                for (DataSnapshot question : dataSnapshot.getChildren()) {
                    Log.i("question", question.getKey());

                    QuestionFB questionFB = question.getValue(QuestionFB.class);
                    questionList.add(questionFB.getQuestion());
                }

                ArrayAdapter arrayAdapter = new ArrayAdapter(Categoria.this, android.R.layout.simple_list_item_1, questionList);
                listView.setAdapter(arrayAdapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(Categoria.this, "The read failed : " + databaseError.getCode(), Toast.LENGTH_LONG).show();
            }
        });
    }
=======
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
>>>>>>> 6e522aa30473121a0190f3a11cbca36fe6878d27
}
