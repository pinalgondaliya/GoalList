package com.oscar.career.goallist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.oscar.career.goallist.adapter.addGoalAdpter;
import com.oscar.career.goallist.database.AppDataBaseQueries;
import com.oscar.career.goallist.database.GoalDatabase;
import com.oscar.career.goallist.database.GoalList;
import com.oscar.career.goallist.database.SubGoalList;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class add_Goal extends AppCompatActivity {
    ImageView showCalender;
    CardView datePick;
    CardView addG;
    RecyclerView currentView;
    EditText goalTitle1;
    TextView selectDate;
    AppDataBaseQueries appDataBaseQueries;

    //https://github.com/androiddeveloper246/GoalListApp

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_goal);

        showCalender = findViewById(R.id.showCalender);
        datePick = findViewById(R.id.setDate);
        addG = findViewById(R.id.addG);
        currentView = findViewById(R.id.currentView);
        goalTitle1 = findViewById(R.id.goalTitle);
        selectDate = findViewById(R.id.selectDate);

        GoalDatabase gb = Room.databaseBuilder(this,GoalDatabase.class,"Goal_Database").allowMainThreadQueries().build();
        appDataBaseQueries = gb.getAllQueries();


        List<SubGoalList> data = new ArrayList<>();
//        data.add("java");
//        data.add("python");
//        data.add("cidi");

        addGoalAdpter a = new addGoalAdpter(currentView,data);
        currentView.setAdapter(a);

        currentView.setLayoutManager(new LinearLayoutManager(this));

        addG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                data.add(" ");

                SubGoalList sub = new SubGoalList("dfrg",1);
                data.add(sub);
                appDataBaseQueries.insertSubGoalData(sub);
                currentView.getAdapter().notifyDataSetChanged();
            }
        });

        Calendar cal = Calendar.getInstance();
        long date = cal.getTime().getTime();

        datePick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialDatePicker datePicker = MaterialDatePicker.Builder.datePicker().setSelection(date).build();
                datePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
                    @Override
                    public void onPositiveButtonClick(Object selection) {
                        selectDate.setText(datePicker.getHeaderText());
                    }
                });
                datePicker.show(getSupportFragmentManager(),"tag1");
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.save,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (R.id.savebtn == item.getItemId()){

            String goalTitle = goalTitle1.getText().toString();
            String goalDate = selectDate.getText().toString();


            GoalList g = new GoalList(goalTitle,goalDate);
            appDataBaseQueries.insertGoalList(g);




            //check date validation
//            if(!goalTitle.getText().toString().isEmpty()){
//                if(!selectDate.getText().toString().equals("Select Date")){
//
//                }else{
//                    AlertDialog.Builder alert = new AlertDialog.Builder(this);
//                    alert.setTitle("alert");
//                    alert.setMessage("please select the date");
//                    alert.setPositiveButton("date", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            Toast.makeText(add_Goal.this, "ok", Toast.LENGTH_SHORT).show();
//                        }
//                    }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            Toast.makeText(add_Goal.this, "cancel", Toast.LENGTH_SHORT).show();
//                        }
//                    }).create();
//                    alert.show();
//                }
//            }//check title validation
//            else if(!selectDate.getText().toString().equals("Select Date")){
//                if (!goalTitle.getText().toString().isEmpty()){
//
//                }else{
//                    AlertDialog.Builder ab = new AlertDialog.Builder(this);
//                    ab.setTitle("alert");
//                    ab.setMessage("please Enter the title first");
//                    ab.setPositiveButton("ok", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            Toast.makeText(add_Goal.this, "ok", Toast.LENGTH_SHORT).show();
//                        }
//                    }).create();
//                    ab.show();
//                }
//            }
//            else{
//                AlertDialog.Builder ab = new AlertDialog.Builder(this);
//                ab.setTitle("alert");
//                ab.setMessage("please select date and title first");
//                ab.setPositiveButton("ok", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(add_Goal.this, "ok", Toast.LENGTH_SHORT).show();
//                    }
//                }).create();
//                ab.show();
//            }
        }
        return super.onOptionsItemSelected(item);
    }
}