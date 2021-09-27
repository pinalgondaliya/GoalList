package com.oscar.career.goallist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.oscar.career.goallist.adapter.addGoalAdpter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.zip.Inflater;

public class add_Goal extends AppCompatActivity {
    ImageView showCalender;
    CardView datePick;
    CardView addG;
    RecyclerView currentView;
    EditText goalTitle;
    TextView selectDate;

    //https://github.com/androiddeveloper246/GoalListApp

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_goal);

        showCalender = findViewById(R.id.showCalender);
        datePick = findViewById(R.id.setDate);
        addG = findViewById(R.id.addG);
        currentView = findViewById(R.id.currentView);
        goalTitle = findViewById(R.id.goalTitle);
        selectDate = findViewById(R.id.selectDate);



        List<String> data = new ArrayList<>();
        data.add("java");
        data.add("python");
        data.add("cidi");

        currentView.setLayoutManager(new LinearLayoutManager(this));

        addG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addGoalAdpter a = new addGoalAdpter(currentView,data);
                currentView.setAdapter(a);
            }
        });

        Calendar cal = Calendar.getInstance();
        long date = cal.getTime().getTime();

        datePick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialDatePicker datePicker = MaterialDatePicker.Builder.datePicker().setSelection(date).build();
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
            if(!goalTitle.getText().toString().isEmpty()){

            }else{
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("exit");
                builder.setMessage("please enter the goal title");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(add_Goal.this, "ok", Toast.LENGTH_SHORT).show();
                    }
                }).create();
                builder.show();
            }

            if(!goalTitle.getText().toString().isEmpty()){
                if(!selectDate.getText().toString().isEmpty()){

                }else{
                    AlertDialog.Builder alert = new AlertDialog.Builder(this);
                    alert.setTitle("alert");
                    alert.setMessage("please select the date");
                    alert.setPositiveButton("date", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(add_Goal.this, "ok", Toast.LENGTH_SHORT).show();
                        }
                    }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(add_Goal.this, "cancel", Toast.LENGTH_SHORT).show();
                        }
                    }).create();
                    alert.show();
                }

            }else{
                AlertDialog.Builder ab = new AlertDialog.Builder(this);
                ab.setTitle("alert");
                ab.setMessage("please select date and title first");
                ab.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(add_Goal.this, "ok", Toast.LENGTH_SHORT).show();
                    }
                }).create();
                ab.show();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}