package com.oscar.career.goallist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.oscar.career.goallist.adapter.addGoalAdpter;

import java.util.Calendar;
import java.util.Date;

public class add_Goal extends AppCompatActivity {
    ImageView showCalender;
    CardView datePick;
    CardView addG;
    RecyclerView currentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_goal);

        showCalender = findViewById(R.id.showCalender);
        datePick = findViewById(R.id.setDate);
        addG = findViewById(R.id.addG);
        currentView = findViewById(R.id.currentView);

        currentView.setAdapter(new addGoalAdpter());

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
}