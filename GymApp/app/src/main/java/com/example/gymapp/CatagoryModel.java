package com.example.gymapp;

import java.util.ArrayList;

public class CatagoryModel {
    private ArrayList<ExcersiceModel> excersiceModel;
    private String catagoryname;
    private int catagoryimage;

    CatagoryModel(int img, String name, ArrayList<ExcersiceModel> model){
        this.catagoryimage=img;
        this.catagoryname=name;
        this.excersiceModel=model;
    }

    public ArrayList<ExcersiceModel> getExcersiceModel() {
        return excersiceModel;
    }

    public String getCatagoryname() {
        return catagoryname;
    }

    public int getCatagoryimage() {
        return catagoryimage;
    }
}
