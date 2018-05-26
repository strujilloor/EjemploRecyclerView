package com.stiven.ejemplorecyclerview;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stiven.ejemplorecyclerview.model.Deuda;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<Deuda> mDataset;
    private int resource;
    private Activity activity;

    public MyAdapter(ArrayList<Deuda> myDataset, int resource, Activity activity) {
        this.mDataset = myDataset;
        this.resource = resource; // the layout that contains the cardview in this example
        this.activity = activity;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nombre_card;
        public TextView deuda_card;

        public ViewHolder(View v) {
            super(v);
            nombre_card = (TextView) v.findViewById(R.id.nombre_card);
            deuda_card = (TextView) v.findViewById(R.id.deuda_card);
        }

    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(this.resource, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Deuda deuda = mDataset.get(position);
        holder.nombre_card.setText(deuda.getNombre());
        holder.deuda_card.setText(deuda.getDeuda());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void addToList(Deuda deuda){
        mDataset.add(deuda);
    }


}
