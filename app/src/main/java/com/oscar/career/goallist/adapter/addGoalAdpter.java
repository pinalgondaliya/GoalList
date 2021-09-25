package com.oscar.career.goallist.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.oscar.career.goallist.R;

public class addGoalAdpter extends RecyclerView.Adapter<addGoalAdpter.MyAddGoal> {

    RecyclerView currentRecyclerView;

    public addGoalAdpter(RecyclerView currentRecyclerView) {
        this.currentRecyclerView = currentRecyclerView;
    }

    @NonNull
    @Override
    public MyAddGoal onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new MyAddGoal(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAddGoal holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public  class MyAddGoal extends RecyclerView.ViewHolder{

        ImageView  dragOntouch;
        ImageView deleteNote;
        TextView addNewItem;

        public MyAddGoal(@NonNull View itemView) {
            super(itemView);
            dragOntouch = itemView.findViewById(R.id.dragOnTouch);
            deleteNote = itemView.findViewById(R.id.deleteNote);
            addNewItem = itemView.findViewById(R.id.addNewItem);


        }
    }
}
