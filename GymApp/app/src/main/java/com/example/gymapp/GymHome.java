package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class GymHome extends AppCompatActivity {
    RecyclerView CatagoryRV;
    CatagoryAdapter myadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_home);

        CatagoryRV = findViewById(R.id.allexeMainRecyclerview);
        CatagoryRV.setLayoutManager(new LinearLayoutManager(this));
        myadapter = new CatagoryAdapter(Catagorylist());

        CatagoryRV.setAdapter(myadapter);

    }

    private ArrayList<CatagoryModel> Catagorylist() {
        ArrayList<CatagoryModel> list = new ArrayList<>();
        CatagoryModel model = new CatagoryModel(R.drawable.gymlogo,"Limon",Excerciselist());
        list.add(model);
        CatagoryModel model2 = new CatagoryModel(R.drawable.bodybuilding,"mustafiz choto",Excerciselist());
        list.add(model2);
        CatagoryModel mode3 = new CatagoryModel(R.drawable.gymlogo,"Limon",Excerciselist());
        list.add(mode3);
        CatagoryModel model4 = new CatagoryModel(R.drawable.bodybuilding,"mustafiz boro",Excerciselist());
        list.add(model4);
        CatagoryModel model5 = new CatagoryModel(R.drawable.gymlogo,"Limon",Excerciselist());
        list.add(model5);
        CatagoryModel model6 = new CatagoryModel(R.drawable.bodybuilding,"mustafiz choto",Excerciselist());
        list.add(model6);
        CatagoryModel model7 = new CatagoryModel(R.drawable.gymlogo,"Limon",Excerciselist());
        list.add(model7);
        CatagoryModel model8 = new CatagoryModel(R.drawable.bodybuilding,"mustafiz boro",Excerciselist());
        list.add(model8);
        return list;
    }

    private ArrayList<ExcersiceModel> Excerciselist() {
        ArrayList<ExcersiceModel> list = new ArrayList<>();
        list.add(new ExcersiceModel(R.drawable.bodybuilding,"paglami"));
        list.add(new ExcersiceModel(R.drawable.defaultweight,"saglami"));
        list.add(new ExcersiceModel(R.drawable.gymlogo,"paglami"));
        list.add(new ExcersiceModel(R.drawable.defaultweight,"saglami"));
        list.add(new ExcersiceModel(R.drawable.gymlogo,"paglami"));
        list.add(new ExcersiceModel(R.drawable.defaultweight,"saglami"));
        return list;
    }
}