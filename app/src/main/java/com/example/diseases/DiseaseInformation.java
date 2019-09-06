package com.example.diseases;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DiseaseInformation extends AppCompatActivity {
    private TextView name;
    private TextView description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease_information);
        name = findViewById(R.id.name);
        description = findViewById(R.id.description);

    }
}