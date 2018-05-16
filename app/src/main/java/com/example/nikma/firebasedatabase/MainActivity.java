package com.example.nikma.firebasedatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    Spinner spinner;
    DatabaseReference databaseReference;
    ListView listView;
    List<Artist> artistlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.name);
        spinner = findViewById(R.id.mspinner);
        button = findViewById(R.id.button);
        databaseReference = FirebaseDatabase.getInstance().getReference("artists");
        listView = (ListView)findViewById(R.id.listviewartist);
        artistlist = new ArrayList<>();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addartist();
            }
        });
    }

    private void addartist() {
        String name = editText.getText().toString().trim();
        String genre = spinner.getSelectedItem().toString();
        if(!TextUtils.isEmpty(name))
        {
                    String id = databaseReference.push().getKey();
                    Artist artist = new Artist(id,name,genre);
                    databaseReference.child(id).setValue(artist);
        }else Toast.makeText(getApplicationContext(),"enter value",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                artistlist.clear();
                for(DataSnapshot artistshot:dataSnapshot.getChildren())
                {
                        Artist artist = artistshot.getValue(Artist.class);
                        artistlist.add(artist);
                }
                artisltlist artisltlist = new artisltlist(MainActivity.this,artistlist);
                listView.setAdapter(artisltlist);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
