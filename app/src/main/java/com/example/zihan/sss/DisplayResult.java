package com.example.zihan.sss;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Zihan on 2018/6/27.
 */

public class DisplayResult extends AppCompatActivity{
    TextView tv_number;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        tv_number = (TextView) findViewById(R.id.result_number);
    }


}
