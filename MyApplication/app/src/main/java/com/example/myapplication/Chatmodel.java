package com.example.myapplication;

public class Chatmodel {
    public static final int layout1=1;
    public static final int layout2=2;
    private int viewtype;
    private String msg;

    public Chatmodel(int viewtype, String msg) {
        this.viewtype = viewtype;
        this.msg = msg;
    }

    public int getViewtype() {
        return viewtype;
    }

    public String getMsg() {
        return msg;
    }
}
