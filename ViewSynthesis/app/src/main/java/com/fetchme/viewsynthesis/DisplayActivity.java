package com.fetchme.viewsynthesis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity {
    // 1 - Data
    private ArrayList<Student> list;
    private DataBaseHelper dataBaseHelper;
    private Intent intent;
    private String id;
    // 2 - AdapterView
    private RecyclerView recyclerView;
    // 3 - Adapter
    private MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        mapIdToView();
        setupViews();
    }

    private void setupViews() {
        list = dataBaseHelper.getStudents(id);
        adapter = new MyAdapter(this, list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void mapIdToView() {
        intent = getIntent();
        id = intent.getStringExtra("id");
        recyclerView = findViewById(R.id.recyclerView);
        list = new ArrayList<>();
        dataBaseHelper = new DataBaseHelper(this);

    }
}