package com.stiven.ejemplorecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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

        String[] texto = new String[20];

        texto[0] = "hola";
        texto[1] = "Mundo";
        texto[2] = "hola";
        texto[3] = "Mundo";
        texto[4] = "hola";
        texto[5] = "Mundo";
        texto[6] = "hola";
        texto[7] = "Mundo";
        texto[8] = "hola";
        texto[9] = "Mundo";
        texto[10] = "hola";
        texto[11] = "Mundo";
        texto[12] = "hola";
        texto[13] = "Mundo";
        texto[14] = "hola";
        texto[15] = "Mundo";
        texto[16] = "hola";
        texto[17] = "Mundo";
        texto[18] = "hola";
        texto[19] = "Mundo";

        // specify an MyAdapter (see also next example)
        mAdapter = new MyAdapter(texto);
        mRecyclerView.setAdapter(mAdapter);

    }
}
