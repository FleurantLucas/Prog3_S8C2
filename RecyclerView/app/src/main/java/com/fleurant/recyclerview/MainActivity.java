package com.fleurant.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    BingoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initRecycler();
        this.remplirRecycler();
    }

    private void remplirRecycler() {
        for (int i = 0 ; i < 5 ; i++) {
            BingoData p = new BingoData();
            p.NoTirer = new Random().nextInt(75)+1;
            p.NoTirage = i+1;
            if(p.NoTirer < 16)
            {
                p.lettre = 'B';
            }
            else if(p.NoTirer < 31)
            {
                p.lettre = 'I';
            }
            else if(p.NoTirer < 46)
            {
                p.lettre = 'N';
            }
            else if(p.NoTirer < 61)
            {
                p.lettre = 'G';
            }
            else
            {
                p.lettre = 'O';
            }
            adapter.localDataSet.add(0,p);
        }
        adapter.notifyDataSetChanged();
    }
    private void initRecycler(){
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        adapter = new BingoAdapter();
        recyclerView.setAdapter(adapter);
    }
}