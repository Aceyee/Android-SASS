package com.squareink.zihan.sss;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    EditText ET_NAME, ET_PASS;              // EditText for username and password
    String login_name, login_pass;          // String to store the value of above EditText

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ET_NAME=findViewById(R.id.user_name);
        ET_PASS=findViewById(R.id.user_pass);
    }

    /**
     * @param view
     * Invoked when user clicks login button
     */
    public void userLogin(View view){
        login_name = ET_NAME.getText().toString();
        login_pass = ET_PASS.getText().toString();
        String method = "login";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method, login_name, login_pass);
    }

    /**
     * @param view
     * Invoked when user clicks register button
     */
    public void userReg(View view){
        // IMPORTANT: new activity need to be declared in Manifests
        startActivity(new Intent(this, Register.class));
    }
}
