package com.example.gymapp;

public class ExcersiceModel {
    private int excimage;
    private String excname;

    //constructor
    ExcersiceModel(int image, String name){
        this.excimage=image;
        this.excname=name;
    }

    //getter for two
    public int getExcimage() {
        return excimage;
    }
    public String getExcname() {
        return excname;
    }
}
