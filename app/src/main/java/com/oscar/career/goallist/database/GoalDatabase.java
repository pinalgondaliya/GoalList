package com.oscar.career.goallist.database;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(version = 2,entities = {GoalList.class,SubGoalList.class})
public abstract class GoalDatabase extends RoomDatabase {

    public abstract AppDataBaseQueries getAllQueries();

}
