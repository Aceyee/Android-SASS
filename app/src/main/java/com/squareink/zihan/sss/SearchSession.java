package com.squareink.zihan.sss;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class SearchSession extends AppCompatActivity {
    EditText ET_SEARCHINPUT;
    String searchtext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchsession_layout);
        ET_SEARCHINPUT=findViewById(R.id.searchinput);
    }

    public void search(View view){
        searchtext = ET_SEARCHINPUT.getText().toString();
        String method = "search";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method, searchtext);
        finish();
    }
}
