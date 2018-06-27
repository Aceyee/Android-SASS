package com.example.zihan.sss;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Zihan on 2018/5/23.
 */

public class Register extends Activity {
    EditText ET_USER_NAME, ET_USER_PASS, ET_USER_UNIVERSITY, ET_USER_STUDENTNO, ET_USER_EMAIL;
    String user_name, user_pass, user_roll, user_university, user_studentNO, user_email;
    Spinner spinner;
    ArrayAdapter<CharSequence> arrayAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        ET_USER_NAME=(EditText)findViewById(R.id.new_user_name);
        ET_USER_PASS=(EditText)findViewById(R.id.new_user_pass);
        ET_USER_UNIVERSITY=(EditText)findViewById(R.id.new_user_university);
        ET_USER_STUDENTNO=(EditText)findViewById(R.id.new_user_studentNO);
        ET_USER_EMAIL=(EditText)findViewById(R.id.new_user_email);
        spinner = (Spinner)findViewById(R.id.spinner);
        arrayAdapter = ArrayAdapter.createFromResource(this, R.array.role_name, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getBaseContext(), adapterView.getItemAtPosition(i)+" selected", Toast.LENGTH_LONG).show();
                user_roll= (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void userReg(View view){
        user_name=ET_USER_NAME.getText().toString();
        user_pass=ET_USER_PASS.getText().toString();
        user_university=ET_USER_UNIVERSITY.getText().toString();
        user_studentNO=ET_USER_STUDENTNO.getText().toString();
        user_email=ET_USER_EMAIL.getText().toString();
        String method = "register";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method, user_name, user_pass,
                user_university, user_roll, user_email, user_studentNO);
        finish();
    }
}
