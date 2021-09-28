package com.oscar.career.goallist.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class GoalList {

    @PrimaryKey(autoGenerate = true)
    int Column_id;

    @ColumnInfo(name = "goal_title")
    public String goalTitle;

    @ColumnInfo(name = "date")
    public String date;

    @ColumnInfo(name = "editNote")
    public String editNote;


    public GoalList(int column_id, String goalTitle, String date, String editNote) {
        Column_id = column_id;
        this.goalTitle = goalTitle;
        this.date = date;
        this.editNote = editNote;
    }

    public int getColumn_id() {
        return Column_id;
    }

    public void setColumn_id(int column_id) {
        Column_id = column_id;
    }

    public String getGoalTitle() {
        return goalTitle;
    }

    public void setGoalTitle(String goalTitle) {
        this.goalTitle = goalTitle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEditNote() {
        return editNote;
    }

    public void setEditNote(String editNote) {
        this.editNote = editNote;
    }
}
