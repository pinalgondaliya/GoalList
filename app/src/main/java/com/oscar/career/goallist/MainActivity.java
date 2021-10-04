package com.oscar.career.goallist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.oscar.career.goallist.adapter.MainGoalAdapter;
import com.oscar.career.goallist.database.AppDataBaseQueries;
import com.oscar.career.goallist.database.GoalDatabase;
import com.oscar.career.goallist.database.GoalList;

import java.util.List;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    public static AppDataBaseQueries appDataBaseQueries;
    RecyclerView rv;
    ImageView deleteGoal;
   public static List<GoalList> goalLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);

        GoalDatabase gb = Room.databaseBuilder(this,GoalDatabase.class,"Goal_Database").allowMainThreadQueries().build();
        appDataBaseQueries = gb.getAllQueries();

        rv.setLayoutManager(new LinearLayoutManager(this));

        goalLists = appDataBaseQueries.getAllData();
        rv.setAdapter(new MainGoalAdapter(rv,goalLists,this));


    }

    public ImageView getDeleteGoal(){
        return deleteGoal;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_goal,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.addGoalItem){
            Intent intent = new Intent(MainActivity.this,add_Goal.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}