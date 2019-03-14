package com.squareink.zihan.sss;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by Zihan on 2018/5/23.
 */

public class Register extends Activity {
    // EditTexts for username, password, university, student number, and email
    EditText ET_USER_NAME, ET_USER_PASS, ET_USER_UNIVERSITY, ET_USER_STUDENTNO, ET_USER_EMAIL;

    // strings to store the above EditText
    String user_name, user_pass, user_role, user_university, user_studentNO, user_email;

    // spinner for toggling roles between student and professor
    Spinner spinner;

    // array adapter for spinner
    ArrayAdapter<CharSequence> arrayAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);

        // bind with corresponding Views in the activity_login.xml
        ET_USER_NAME = findViewById(R.id.new_user_name);
        ET_USER_PASS = findViewById(R.id.new_user_pass);
        ET_USER_UNIVERSITY = findViewById(R.id.new_user_university);
        ET_USER_STUDENTNO = findViewById(R.id.new_user_studentNO);
        ET_USER_EMAIL = findViewById(R.id.new_user_email);
        spinner = findViewById(R.id.spinner);

        // set up array adapter and spinner
        arrayAdapter = ArrayAdapter.createFromResource(this, R.array.role_name, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getBaseContext(), adapterView.getItemAtPosition(i)+" selected", Toast.LENGTH_LONG).show();
                user_role = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    /**
     * @param view
     * Invoked when user clicks register button in the activity_register.xml
     */
    public void userReg(View view) {
        // store EditText value into strings
        user_name = ET_USER_NAME.getText().toString();
        user_pass = ET_USER_PASS.getText().toString();
        user_university = ET_USER_UNIVERSITY.getText().toString();
        user_studentNO = ET_USER_STUDENTNO.getText().toString();
        user_email = ET_USER_EMAIL.getText().toString();

        // execute backgroundTask to register a new user
        String method = "register";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method, user_name, user_pass,
                user_university, user_role, user_email, user_studentNO);
    }
}
