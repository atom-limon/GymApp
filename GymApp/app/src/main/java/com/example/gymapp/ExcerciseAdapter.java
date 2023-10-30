package com.example.gymapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExcerciseAdapter extends RecyclerView.Adapter {
    ArrayList<ExcersiceModel> exclist;


    ExcerciseAdapter(ArrayList<ExcersiceModel> list){
        this.exclist=list;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inside_catagory_recyclerview_view,parent,false);
        return new catagoryviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ExcersiceModel model = exclist.get(position);
        ((catagoryviewholder)holder).setview(model.getExcname(),model.getExcimage());
        return;
    }

    @Override
    public int getItemCount() {
        return exclist.size();
    }

    class catagoryviewholder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView txt;
        public catagoryviewholder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.instumentimg);
            txt = itemView.findViewById(R.id.instumentname);
        }

        private void setview(String name, int image){
            img.setImageResource(image);
            txt.setText(name);
        }
    }

}
