package com.example.gymapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CatagoryAdapter extends RecyclerView.Adapter {
    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
     private ArrayList<CatagoryModel> catagoryModelArrayList;

    CatagoryAdapter(ArrayList<CatagoryModel> list){
        this.catagoryModelArrayList=list;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.allexe_main_recyclerview_view,parent,false);
        return new Catagoryviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CatagoryModel model = catagoryModelArrayList.get(position);
        ((Catagoryviewholder)holder).setview(model.getCatagoryimage(),model.getCatagoryname());
        LinearLayoutManager layoutManager = new LinearLayoutManager(((Catagoryviewholder) holder).childrv.getContext(),
                LinearLayoutManager.HORIZONTAL,false);
        layoutManager.setInitialPrefetchItemCount(model.getExcersiceModel().size());
        ExcerciseAdapter excerciseAdapter = new ExcerciseAdapter(model.getExcersiceModel());
        ((Catagoryviewholder) holder).childrv.setLayoutManager(layoutManager);
        ((Catagoryviewholder) holder).childrv.setAdapter(excerciseAdapter);
        ((Catagoryviewholder) holder).childrv.setRecycledViewPool(viewPool);
    }

    @Override
    public int getItemCount() {
        return catagoryModelArrayList.size();
    }

    class Catagoryviewholder extends RecyclerView.ViewHolder{
        private TextView catagory;
        private ImageView catimage;
        private RecyclerView childrv;
        public Catagoryviewholder(@NonNull View itemView) {
            super(itemView);
            catagory = itemView.findViewById(R.id.catagoryname);
            catimage = itemView.findViewById(R.id.iv_WeightLift);
            childrv = itemView.findViewById(R.id.CatagoryLiftRecyclerview);

        }
        private void setview(int img, String name){
            catimage.setImageResource(img);
            catagory.setText(name);
        }
    }
}
