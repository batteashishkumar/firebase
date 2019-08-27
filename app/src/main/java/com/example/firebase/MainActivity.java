package com.example.firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
Obj x;
EditText id,name,phone;
public int id_text,phone_text;
String name_text;
    DatabaseReference myRef;
    FirebaseDatabase database;
    long child_count;
    String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id=(EditText) findViewById(R.id.edittext_id);
        name=findViewById(R.id.edittext_name);
        phone=findViewById(R.id.edittext_phone);
        database = FirebaseDatabase.getInstance();
        update_child_count();

    }
    public void add(View view)
    {
        myRef = database.getReference("message"+Long.toString(child_count));
        id_text=Integer.parseInt(id.getText().toString());
        name_text=name.getText().toString();
        phone_text=Integer.parseInt(phone.getText().toString());
        x=new Obj(id_text,name_text,phone_text);
        myRef.setValue(x);
        Toast.makeText(this,"added",Toast.LENGTH_LONG).show();
        update_child_count();

    }
    public void update_child_count()
    {

        myRef = database.getReference();
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                long count = dataSnapshot.getChildrenCount();
                Log.d("TAG", "count= " + count);
                child_count=count;
                Toast.makeText(MainActivity.this,count+"",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        };
        myRef.addListenerForSingleValueEvent(valueEventListener);
    }
    public void view_contacts(View view){
        Intent i=new Intent(this,Main2Activity.class);
        startActivity(i);

    }

}
