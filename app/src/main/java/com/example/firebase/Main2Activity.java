package com.example.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main2Activity extends AppCompatActivity {
    TextView textview_id;
    DatabaseReference myRef;
    FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textview_id=findViewById(R.id.textview);
        database= FirebaseDatabase.getInstance();
        myRef = database.getReference();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               // String post = dataSnapshot.getValue(String.class);
               // textview_id.setText(post);
for(int i=0;i<3;i++) {
    String name = dataSnapshot.child("message"+Integer.toString(i)).child("name").getValue().toString();
    String id=dataSnapshot.child("message"+Integer.toString(i)).child("id").getValue().toString();
    String phone=dataSnapshot.child("message"+Integer.toString(i)).child("phone").getValue().toString();
    textview_id.setGravity(2);
    textview_id.append("\n"+id );
    textview_id.append("\n"+name );
    textview_id.append("\n"+phone);
    textview_id.append("\n----------");

}
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(Main2Activity.this, "failed to get data", Toast.LENGTH_SHORT).show();
            }
        });



    }

}
