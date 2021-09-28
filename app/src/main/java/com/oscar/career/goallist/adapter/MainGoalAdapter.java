package com.oscar.career.goallist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.oscar.career.goallist.R;
import com.oscar.career.goallist.database.GoalList;

import org.w3c.dom.Text;

import java.util.List;

public class MainGoalAdapter extends RecyclerView.Adapter<MainGoalAdapter.MainGoal> {
    List<GoalList> mainGoals;
    Context context;

    public MainGoalAdapter(List<GoalList> mainGoals, Context context) {
        this.mainGoals = mainGoals;
        this.context = context;
    }

    @NonNull
    @Override
    public MainGoal onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_goal_item,parent,false);
        return new MainGoal(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MainGoal holder, int position) {
        holder.goalTitle.setText(mainGoals.get(position).getGoalTitle());
        holder.goalDate.setText(mainGoals.get(position).getDate());
        holder.subGoalData.setText(mainGoals.get(position).getEditNote());
    }

    @Override
    public int getItemCount() {
        return mainGoals.size();
    }

    public class MainGoal extends RecyclerView.ViewHolder{

        TextView goalTitle;
        TextView goalDate;
        TextView subGoalData;

        public MainGoal(@NonNull View itemView) {

            super(itemView);

            goalTitle = itemView.findViewById(R.id.goalTitle);
            goalDate = itemView.findViewById(R.id.goalDate);
            subGoalData = itemView.findViewById(R.id.subGoalData);
        }
    }
}
