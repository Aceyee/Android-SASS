package com.example.zihan.sss;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Zihan on 2018/6/27.
 */

public class DisplayResult extends AppCompatActivity{
    private static TextView tv_number;
    private static int num;
    private int id;
    private Context ctx;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        ctx=this;
        Bundle extra = getIntent().getExtras();
        if (extra!=null){
            id = extra.getInt("courseid");
        }
        tv_number = (TextView) findViewById(R.id.result_number);
        tv_number.setText(num+"");
        String method = "display";
        BackgroundTask backgroundTask = new BackgroundTask(ctx);
        backgroundTask.execute(method, id+"");
        Timer timer = new Timer ();
        TimerTask secondTask = new TimerTask () {
            @Override
            public void run () {

                //  finish();
            }
        };
        timer.schedule (secondTask, 0, 1000);
    }

    public static void setNum(int num) {
        DisplayResult.num = num;
        tv_number.setText(num+"");
    }
}
