package com.fleurant.orderalpha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    NomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initRecycler();
        this.remplirRecycler();
    }

    private void remplirRecycler() {
        adapter.localDataSet.add("Jean");
        adapter.localDataSet.add("Bob");
        adapter.localDataSet.add("Alfred");
        adapter.localDataSet.add("Paul");
        adapter.notifyDataSetChanged();
    }
    private void initRecycler(){
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        adapter = new NomAdapter();
        recyclerView.setAdapter(adapter);
    }

}