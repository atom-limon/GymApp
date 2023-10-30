package com.example.myapplication;

import static com.example.myapplication.Chatmodel.layout1;
import static com.example.myapplication.Chatmodel.layout2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class Myadapter extends RecyclerView.Adapter {
    //
    ArrayList<Chatmodel> list;
    Context context;
    recycleritemhold listener;

    public void setListener(recycleritemhold listener) {
        this.listener = listener;
    }

    Myadapter(ArrayList<Chatmodel> list, Context  context){
        this.list=list;
        this.context=context;
    }

    @Override
    public int getItemViewType(int position) {
        switch (list.get(position).getViewtype()){
            case 1:
                return layout1;
            case 2:
                return layout2;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType){
            case layout1:
                return new txtsendholder(view = LayoutInflater.from(context).inflate(R.layout.txt_send,parent,false));
            case layout2:
                return new txtrecholder(view = LayoutInflater.from(context).inflate(R.layout.txt_rec,parent,false));
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Chatmodel model = list.get(position);
        switch (model.getViewtype()){
            case layout1:
                ((txtsendholder)holder).setview(model.getMsg());
                break;
            case layout2:
                ((txtrecholder)holder).setview(model.getMsg());
                break;
            default: ;
        }

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                listener.onitemhold(holder.getAdapterPosition());
                return true;
            }
        });

        setAnimationView(holder.itemView,position);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void deleteitem(int position){
        list.remove(position);
        notifyItemRemoved(position);
    }

    private void setAnimationView(View view, int position){
        Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        view.startAnimation(animation);
    }

    class txtsendholder extends RecyclerView.ViewHolder{
        private final TextView text;
        public txtsendholder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.txtsend);
        }
        private void setview(String msg){
            text.setText(msg);
        }
    }

    class txtrecholder extends RecyclerView.ViewHolder{
        TextView text;
        public txtrecholder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.txtrec);
        }
        private void setview(String msg){
            text.setText(msg);
        }
    }
}
