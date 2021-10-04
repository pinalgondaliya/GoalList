package com.oscar.career.goallist.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.RoomDatabase;

import com.oscar.career.goallist.MainActivity;
import com.oscar.career.goallist.R;
import com.oscar.career.goallist.add_Goal;
import com.oscar.career.goallist.database.GoalDatabase;
import com.oscar.career.goallist.database.GoalList;
import com.oscar.career.goallist.database.SubGoalList;

import org.w3c.dom.Text;

import java.util.List;

public class MainGoalAdapter extends RecyclerView.Adapter<MainGoalAdapter.MainGoal> {
//    List<GoalList> mainGoals;
    Context context;
    RecyclerView rv;

    public MainGoalAdapter(RecyclerView rv,List<GoalList> mainGoals, Context context) {
//        this.mainGoals = mainGoals;
        this.rv = rv;
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
        holder.setIsRecyclable(false);
        holder.goalTitle.setText(MainActivity.goalLists.get(position).getGoalTitle());
        holder.goalDate.setText(MainActivity.goalLists.get(position).getGoalDate());
        RecyclerView subGoal = holder.getChildRecyclerView();

        holder.deleteGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.goalLists.remove(position);
                rv.removeViewAt(position);
                notifyItemRemoved(position);

            }
        });

        LinearLayout temp = holder.getExpandMenu();
        List<SubGoalList> dataOnly ;

        holder.expandView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subGoal.setLayoutManager(new LinearLayoutManager(context));
                subGoal.setAdapter(new subhTaskAdapter(dataOnly,context));

                temp.setVisibility(View.VISIBLE);
                holder.getExpandMenu().setVisibility(View.INVISIBLE);
            }
        });


        holder.updateGoals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, add_Goal.class);
                holder.goalTitle.getText().toString();
                holder.goalDate.getText().toString();
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return MainActivity.goalLists.size();
    }

    public class MainGoal extends RecyclerView.ViewHolder{

        TextView goalTitle;
        TextView goalDate;
        ImageView deleteGoal;
        RecyclerView rv;
        ImageView updateGoals;
        TextView subGoalData;
        ImageView expandView;
        LinearLayout expandMenu;
        RecyclerView childRecyclerView;

        public MainGoal(@NonNull View itemView) {

            super(itemView);

            goalTitle = itemView.findViewById(R.id.goalTitle);
            goalDate = itemView.findViewById(R.id.goalDate);
            deleteGoal = itemView.findViewById(R.id.deleteGoal);
            updateGoals = itemView.findViewById(R.id.updateGoals);
            expandMenu = itemView.findViewById(R.id.expandMenu);
            childRecyclerView = itemView.findViewById(R.id.addSubTaskHere);
            rv = itemView.findViewById(R.id.rv);
            expandView = itemView.findViewById(R.id.expandView);
        }
        public ImageView getDeleteNote(){
            return deleteGoal;
        }
        public ImageView getUpdateGoals(){
            return updateGoals;
        }
        public LinearLayout getExpandMenu(){
            return expandMenu;
        }

        public RecyclerView getChildRecyclerView(){
            return  childRecyclerView;
        }
    }
}
