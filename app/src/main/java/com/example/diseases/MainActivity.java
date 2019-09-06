package com.example.diseases;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.diseases.adapter.RecyclerViewAdapter;
import com.example.diseases.data.DatabaseHandler;
import com.example.diseases.model.Disease;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Disease> diseasesArrayList;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHandler db = new DatabaseHandler(MainActivity.this);
        diseasesArrayList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);



//        db.addDiseases(new Disease("a", "aaaaaaaaaaaaaaaaaa"));
//        db.addDiseases(new Disease("b", "aaaaaaaaaaaaaaaaaa"));
//        db.addDiseases(new Disease("c", "aaaaaaaaaaaaaaaaaa"));



        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Disease> allDiseases = db.getAllDiseases();
        for (Disease d : allDiseases){
            Log.d("MAIN", d.getId() + " | " + d.getName() + " | " + d.getDescriptiom());
            diseasesArrayList.add(d);
        }

        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this , diseasesArrayList);

        recyclerView.setAdapter(recyclerViewAdapter);


    }
}
