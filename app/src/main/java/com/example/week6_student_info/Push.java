package com.example.week6_student_info;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Push extends AppCompatActivity {
    TextView textView1;
    String name,lname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push);
        String[] arr = new String[4];
        String id,name,department,subject,year;

        Intent intent=getIntent();

        id=intent.getStringExtra("id");
        name = intent.getStringExtra("name");
        department= intent.getStringExtra("deparment");
        subject = intent.getStringExtra("subject");
        year = intent.getStringExtra("year");

        textView1 = findViewById(R.id.textView);
        textView1.setText("code \n"+ id +" name \n"+name+ " department \n"+department+ " subject \n and "+subject+" year "+year);



    }

}
