package com.stiven.ejemplorecyclerview;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.stiven.ejemplorecyclerview.model.Deuda;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.fab) FloatingActionButton fab;
    @BindView(R.id.recyclerview) RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an MyAdapter (see also next example)
        mAdapter = new MyAdapter(new ArrayList<Deuda>(), R.layout.cardview_deudas, this);
        mRecyclerView.setAdapter(mAdapter);

    }

    @OnClick(R.id.fab) void addCardView(){
        mAdapter.addToList(new Deuda("Nombre: Jason","Deuda: 300.000"));
        showDeudas();

    }

    public void showDeudas(){
        mAdapter.notifyDataSetChanged();
    }
}
