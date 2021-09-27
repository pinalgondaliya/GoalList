package com.oscar.career.goallist.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.oscar.career.goallist.R;

import java.util.List;

public class addGoalAdpter extends RecyclerView.Adapter<addGoalAdpter.MyAddGoal> {

    RecyclerView currentRecyclerView;
    List<String> data;

    public addGoalAdpter(RecyclerView currentRecyclerView, List<String> data) {
        this.currentRecyclerView = currentRecyclerView;
        this.data = data;
    }

    @NonNull
    @Override
    public MyAddGoal onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new MyAddGoal(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAddGoal holder, int position) {
        holder.addNewItem.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public  class MyAddGoal extends RecyclerView.ViewHolder{

        ImageView  dragOntouch;
        ImageView deleteNote;
        TextView addNewItem;

        public MyAddGoal(@NonNull View itemView, ImageView dragOntouch, ImageView deleteNote, TextView addNewItem) {
            super(itemView);
            this.dragOntouch = dragOntouch;
            this.deleteNote = deleteNote;
            this.addNewItem = addNewItem;
        }

        public MyAddGoal(@NonNull View itemView) {
            super(itemView);
            dragOntouch = itemView.findViewById(R.id.dragOnTouch);
            deleteNote = itemView.findViewById(R.id.deleteNote);
            addNewItem = itemView.findViewById(R.id.addNewItem);


        }
    }
}
