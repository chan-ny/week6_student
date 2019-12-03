package com.example.week6_student_info;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText id,name;
    RadioGroup group;
    RadioButton radioButton1;
    CheckBox checkBox1,checkBox2,checkBox3,checkBox4;
    Button button1;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = findViewById(R.id.txt_id);
        name = findViewById(R.id.txt_name);
        spinner= findViewById(R.id.t_spiner);
        checkBox1 = findViewById(R.id.ch_pg);
        checkBox2 = findViewById(R.id.ch_pgm);
        checkBox3 = findViewById(R.id.ch_gd);
        checkBox4 = findViewById(R.id.ch_egn);
        button1 = findViewById(R.id.btn_info);



        String spiner[] ={"Computer Science","Web Development","Programer"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,spiner);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        group = findViewById(R.id.t_rg);




        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] arr = new String[4];
                if(checkBox1.isChecked()==true){
                    arr[0]="Programmer";
                   }else{
                    arr[0]="";
                }
                if(checkBox2.isChecked()==true){
                    arr[1]="Programming";
                }else{
                    arr[1]="";
                }
                if(checkBox3.isChecked()==true){
                    arr[2]="Graphic Design";
                }else{
                    arr[2]="";
                }
                if(checkBox4.isChecked()==true){
                    arr[3]="Engineering";
                }else{
                    arr[3]="";
                }
                int select = group.getCheckedRadioButtonId();

                radioButton1=findViewById(select);
                String ids,names,spera,years;
                ids= id.getText().toString();
                names= name.getText().toString();
                spera= spinner.getSelectedItem().toString();
                years =radioButton1.getText().toString();
                Intent intent = new Intent(MainActivity.this, Push.class);
                intent.putExtra("id",ids);
                intent.putExtra("name",names);
                intent.putExtra("deparment",spera);
                intent.putExtra("subject",getarry(arr));
                intent.putExtra("year",years);
                startActivity(intent);


            }
        });



    }
    public  static String getarry(String[] strings){
        String array = String.join(" ",strings);
        return array;
    }
}
