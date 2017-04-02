package com.example.davidcabello.proyectomoviles;

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
}
