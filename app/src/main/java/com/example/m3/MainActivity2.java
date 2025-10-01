package com.example.m3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity {
    EditText name, num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        name=findViewById(R.id.name);
        num=findViewById(R.id.num);


        BottomNavigationView bt=findViewById(R.id.nav);
        bt.setOnItemSelectedListener(item -> {
            int id=item.getItemId();
            Intent intent=null;
            if (id==R.id.home)
                intent=new Intent(this, MainActivity.class);
            if (id==R.id.add)
                intent=new Intent(this, MainActivity2.class);
            startActivity(intent);
            finish();
            return false;
        });


    }

    public void add(View view) {
        String nameText=name.getText().toString();
        if (name.getText().toString().isEmpty() || num.getText().toString().isEmpty())
            Toast.makeText(this, "fill all fields", Toast.LENGTH_SHORT).show();
        else{
            if (Integer.parseInt(num.getText().toString()) <= 5 && Integer.parseInt(num.getText().toString()) >= 0){
            Intent intent=new Intent(MainActivity2.this, MainActivity.class);
            intent.putExtra("name", nameText);
            startActivity(intent);
            finish();}
            else
                Toast.makeText(this, "number of images should be between 0 and 5", Toast.LENGTH_SHORT).show();
        }
    }
}