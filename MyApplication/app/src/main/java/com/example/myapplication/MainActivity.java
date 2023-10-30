package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements recycleritemhold {
    RecyclerView rv;    ArrayList<Chatmodel> list;
    Myadapter myadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.recyclerview);
        list = new ArrayList<>();
        rv.setLayoutManager(new LinearLayoutManager(this));
        list.add(new Chatmodel(1,"hello i am sender"));
        list.add(new Chatmodel(2,"hello i am reciver"));
        list.add(new Chatmodel(1,"hello i am sender hello i am sender"));
        list.add(new Chatmodel(2,"hello i am reciver hello i am reciver"));
        list.add(new Chatmodel(1,"hello i am sender"));
        list.add(new Chatmodel(2,"hello i am reciver"));
        list.add(new Chatmodel(1,"hello i am sender hello i am sender"));
        list.add(new Chatmodel(2,"hello i am reciver hello i am reciver"));
        list.add(new Chatmodel(1,"hello i am sender"));
        list.add(new Chatmodel(2,"hello i am reciver"));
        list.add(new Chatmodel(1,"hello i am sender hello i am sender"));
        list.add(new Chatmodel(2,"hello i am reciver hello i am reciver"));
        list.add(new Chatmodel(1,"hello i am sender"));
        list.add(new Chatmodel(2,"hello i am reciver"));
        list.add(new Chatmodel(1,"hello i am sender hello i am sender"));
        list.add(new Chatmodel(2,"hello i am reciver hello i am reciver"));
        list.add(new Chatmodel(1,"hello i am sender"));
        list.add(new Chatmodel(2,"hello i am reciver"));
        list.add(new Chatmodel(1,"hello i am sender hello i am sender"));
        list.add(new Chatmodel(2,"hello i am reciver hello i am reciver"));
        list.add(new Chatmodel(1,"hello i am sender"));
        list.add(new Chatmodel(2,"hello i am reciver"));
        list.add(new Chatmodel(1,"hello i am sender hello i am sender"));
        list.add(new Chatmodel(2,"hello i am reciver hello i am reciver"));
        list.add(new Chatmodel(1,"hello i am sender"));
        list.add(new Chatmodel(2,"hello i am reciver"));
        list.add(new Chatmodel(1,"hello i am sender hello i am sender"));
        list.add(new Chatmodel(2,"hello i am reciver hello i am reciver"));

        myadapter = new Myadapter(list,MainActivity.this);

        registerForContextMenu(rv);


        myadapter.setListener(this);

        rv.setAdapter(myadapter);
        //add item in runtime
        ImageButton send = findViewById(R.id.sendbutton);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText newtext = findViewById(R.id.textbox);
                String str = newtext.getText().toString() ;
                if(!str.isEmpty()){
                    list.add(new Chatmodel(1,str));
                    myadapter.notifyItemInserted(list.size()-1);
                    newtext.setText("");
                    rv.scrollToPosition(list.size()-1);
                }
                else newtext.setError("empty message");
            }
        });

        //delete item in runtime
        

    }

    @Override
    public void onitemhold(int position) {

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }
}