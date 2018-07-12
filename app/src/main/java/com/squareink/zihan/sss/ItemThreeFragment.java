package com.squareink.zihan.sss;

/**
 * Created by Zihan on 2018/5/5.
 */


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ItemThreeFragment extends Fragment {
    TextView tv_username;
    TextView tv_univeristy;
    TextView tv_email;
    TextView tv_roll;
    TextView tv_studentNO;
    User user;
    public static ItemThreeFragment newInstance() {
        ItemThreeFragment fragment = new ItemThreeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item_three, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        tv_username = (TextView) view.findViewById(R.id.info_username);
        tv_univeristy = (TextView) view.findViewById(R.id.info_university);
        tv_email = (TextView) view.findViewById(R.id.info_email);
        tv_roll = (TextView) view.findViewById(R.id.info_roll);
        tv_studentNO = (TextView) view.findViewById(R.id.info_studentNO);
        user=MainActivity.getUser();
        setText();
    }

    private void setText() {
        tv_username.setText(user.getUsername());
        tv_email.setText(user.getEmail());
        tv_univeristy.setText(user.getUniversity());
        tv_roll.setText(user.getRoll());
        tv_studentNO.setText(user.getStudentNO());
    }
}
