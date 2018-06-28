package com.example.zihan.sss;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Zihan on 2018/6/27.
 */

public class DisplayResult extends AppCompatActivity{
    private static TextView tv_number;
    private static int num;
    private int id;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        Bundle extra = getIntent().getExtras();
        if (extra!=null){
            id = extra.getInt("courseid");
        }
        tv_number = (TextView) findViewById(R.id.result_number);
        tv_number.setText(num+"");
        String method = "display";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method, id+"");
    }

    public static void setNum(int num) {
        DisplayResult.num = num;
        tv_number.setText(num+"");
    }
}
