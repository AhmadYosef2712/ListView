package com.example.m3;

import android.os.Bundle;
import android.os.Handler;import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  AdapterView.OnItemClickListener{
    private ListView lv;
    private ImageView iv;
    private ArrayList<String> myList;
    private ArrayAdapter<String> adapter;
    private ArrayList<Integer> imageList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.ls);
        iv = findViewById(R.id.img);
        myList = new ArrayList<>();
        myList.add("Banana");
        myList.add("Grape");
        myList.add("Kiwi");
        myList.add("Raspberry");
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, myList);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
        imageList = new ArrayList<>();
        imageList.add(R.drawable.banana);
        imageList.add(R.drawable.grape);
        imageList.add(R.drawable.kiwi);
        imageList.add(R.drawable.raspberry);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
        final Toast toast = Toast.makeText(this, "Click: "+myList.get(i), Toast.LENGTH_SHORT);
        toast.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        }, 700);

        iv.setImageResource(imageList.get(i));
    }
}
