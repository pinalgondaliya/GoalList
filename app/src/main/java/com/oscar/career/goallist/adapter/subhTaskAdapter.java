package com.oscar.career.goallist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.oscar.career.goallist.R;
import com.oscar.career.goallist.database.SubGoalList;

import java.util.List;

public class subhTaskAdapter extends RecyclerView.Adapter <subhTaskAdapter.MySubTask> {

    List<SubGoalList> subGoalListList;
    Context context;

    public subhTaskAdapter(List<SubGoalList> subGoalListList, Context context) {
        this.subGoalListList = subGoalListList;
        this.context = context;
    }

    @NonNull
    @Override
    public MySubTask onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_goal_item,parent,false);
        return new MySubTask(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MySubTask holder, int position) {
        SubGoalList subGoal = subGoalListList.get(position);

        holder.getData().setText(subGoal.getSub_goal_name());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class MySubTask extends RecyclerView.ViewHolder{

        ImageView bulet;
        TextView showSubGoaldata;

        public MySubTask(@NonNull View itemView) {
            super(itemView);
            bulet = itemView.findViewById(R.id.bulet);
            showSubGoaldata = itemView.findViewById(R.id.data);
        }

        public TextView getData(){
            return showSubGoaldata;
        }

    }
}
