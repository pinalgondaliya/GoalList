package com.oscar.career.goallist.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AppDataBaseQueries {

    @Insert
    void insertGoalList(GoalList g);

    @Query("SELECT * FROM GoalList")
    List<GoalList> getAllData();

    @Insert
    void insertSubGoalData(SubGoalList sub);

    @Query("SELECT * FROM SubGoalList")
    List<SubGoalList> getAllSubGoalData();
}
