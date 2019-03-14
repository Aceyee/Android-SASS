package com.squareink.zihan.sss;

/**
 * Created by Zihan on 2018/5/5.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Punch extends AppCompatActivity {
    Button btnPunch;
    static TextView tv_course;
    private String course;
    private int id;
    private User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.punch_layout);
        Bundle extra = getIntent().getExtras();
        if (extra!=null){
            course = extra.getString("coursename");
            id = extra.getInt("courseid");
        }
        user=MainActivity.getUser();
        btnPunch = findViewById(R.id.buttonPunch);
        tv_course = findViewById(R.id.punch_course);
        tv_course.setText(course);
        //System.out.println(user.toString());
        addListener();
    }

    private void addListener() {
        boolean clicked = false;
        btnPunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String method = "punch";
                BackgroundTask backgroundTask = new BackgroundTask(view.getContext());
                backgroundTask.execute(method, id+"", "A", user.getUniversity(), user.getStudentNO(), user.getUsername());
            }
        });
    }
}
