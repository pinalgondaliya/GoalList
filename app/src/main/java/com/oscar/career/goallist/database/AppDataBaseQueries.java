package com.oscar.career.goallist.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AppDataBaseQueries {

    @Insert
    long insertGoalList(GoalList g);

    @Query("SELECT * FROM GoalList")
    List<GoalList> getAllData();

    @Insert
    void insertSubGoalData(SubGoalList sub);

    @Query("SELECT * FROM SubGoalList")
    List<SubGoalList> getAllSubGoalData();

    @Query("DELETE FROM GoalList WHERE column_id=:id")
    void deleteGoalList(int id);

    @Query("DELETE FROM SubGoalList WHERE sub_goal_id=:subid")
    void deleteSubGoalData(int subid);

}
