package com.stiven.ejemplorecyclerview;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
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

        boolean wrapInScrollView = false;
        new MaterialDialog.Builder(this)
                .title("Agregar Deuda")
                .customView(R.layout.custom_dialog, wrapInScrollView)
                .positiveText("Agregar")
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(MaterialDialog dialog, DialogAction which) {
                        View view = dialog.getCustomView();
                        EditText nombre_dialog = (EditText) view.findViewById(R.id.nombre_dialog);
                        EditText deuda_dialog = (EditText) view.findViewById(R.id.deuda_dialog);

                        String nombre = nombre_dialog.getText().toString();
                        String deuda = deuda_dialog.getText().toString();

                        mAdapter.addToList(new Deuda("Nombre: " + nombre_dialog.getText().toString(),
                                "Deuda: " + deuda_dialog.getText().toString()));

                        Toast.makeText(getBaseContext(), "Added [" + nombre +","+deuda+"]",
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .show();

//        showDeudas();
    }

    public void showDeudas(){
        mAdapter.notifyDataSetChanged();
    }
}
