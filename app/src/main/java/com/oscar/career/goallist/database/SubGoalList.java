package com.oscar.career.goallist.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity
public class SubGoalList {

    @PrimaryKey(autoGenerate = true)
    private int sub_goal_id;

    @ColumnInfo(name = "sub_goal_name")
    public String sub_goal_name;

    @ColumnInfo(name = "master_goal_id")
    private int master_goal_id;

    public SubGoalList(String sub_goal_name, int master_goal_id) {
        this.sub_goal_name = sub_goal_name;
        this.master_goal_id = master_goal_id;
    }

    public int getSub_goal_id() {
        return sub_goal_id;
    }

    public void setSub_goal_id(int sub_goal_id) {
        this.sub_goal_id = sub_goal_id;
    }

    public String getSub_goal_name() {
        return sub_goal_name;
    }

    public void setSub_goal_name(String sub_goal_name) {
        this.sub_goal_name = sub_goal_name;
    }

    public int getMaster_goal_id() {
        return master_goal_id;
    }

    public void setMaster_goal_id(int master_goal_id) {
        this.master_goal_id = master_goal_id;
    }
}
