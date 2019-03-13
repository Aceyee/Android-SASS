package com.squareink.zihan.sss;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Zihan on 2018/5/23.
 */

public class CreateSession extends Activity {
    EditText ET_UNIVERSITY_NAME, ET_COURSE_NAME, ET_PROF_NAME;      // EditText
    String university_name, course_name, prof_name;                 // Strings to store above EditText

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createsession_layout);
        ET_UNIVERSITY_NAME = findViewById(R.id.university);
        ET_COURSE_NAME = findViewById(R.id.course);
        ET_PROF_NAME = findViewById(R.id.professor);
    }

    public void createSession(View view) {
        // store the EditText into strings
        university_name = ET_UNIVERSITY_NAME.getText().toString();
        course_name = ET_COURSE_NAME.getText().toString();
        prof_name = ET_PROF_NAME.getText().toString();

        // execute backgroundTask to create session
        String method = "createSession";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method, university_name, course_name, prof_name);
        finish();
    }
}
