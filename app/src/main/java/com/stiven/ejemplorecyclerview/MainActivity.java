package com.stiven.ejemplorecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.stiven.ejemplorecyclerview.model.Deuda;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<Deuda> deudas = new ArrayList<>();
        deudas.add(new Deuda("Jason","300.000"));
        deudas.add(new Deuda("Carolina","200.000"));
        deudas.add(new Deuda("Carolina","25.000"));
        deudas.add(new Deuda("Olave","3.000"));
        deudas.add(new Deuda("Luis","100.000"));
        deudas.add(new Deuda("Robles","16.000"));
        deudas.add(new Deuda("Jaime","50.000"));
        deudas.add(new Deuda("Victor","3.000.000"));

        // specify an MyAdapter (see also next example)
        mAdapter = new MyAdapter(deudas);
        mRecyclerView.setAdapter(mAdapter);

    }
}
