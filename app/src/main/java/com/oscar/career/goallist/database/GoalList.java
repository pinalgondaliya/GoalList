package com.oscar.career.goallist.database;

import static androidx.room.ForeignKey.CASCADE;

import androidx.recyclerview.widget.RecyclerView;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity

public class GoalList {

    @PrimaryKey(autoGenerate = true)
    int column_id;

    @ColumnInfo(name = "goalTitle")
    public String goalTitle;

    @ColumnInfo(name = "goalDate")
    public String goalDate;


    public GoalList(String goalTitle,String goalDate) {
        this.goalTitle = goalTitle;
        this.goalDate = goalDate;
    }

    public String getGoalDate() {
        return goalDate;
    }

    public void setGoalDate(String goalDate) {
        this.goalDate = goalDate;
    }

    public int getColumn_id() {
        return column_id;
    }

    public void setColumn_id(int column_id) {
        this.column_id = column_id;
    }

    public String getGoalTitle() {
        return goalTitle;
    }

    public void setGoalTitle(String goalTitle) {
        this.goalTitle = goalTitle;
    }

}
