package com.example.zihan.sss;

/**
 * Created by Zihan on 2018/5/5.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ItemOneFragment extends Fragment {
    Button a;
    Button b;
    Button c;
    Button d;
    Button e;
    public static ItemOneFragment newInstance() {
        ItemOneFragment fragment = new ItemOneFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item_one, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        a = (Button) getView().findViewById(R.id.buttonA);
        b = (Button) getView().findViewById(R.id.buttonB);
        c = (Button) getView().findViewById(R.id.buttonC);
        d = (Button) getView().findViewById(R.id.buttonD);
        e = (Button) getView().findViewById(R.id.buttonE);
        initialize();
    }

    private void initialize() {
        addListener();
    }

    private void addListener() {
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("A被点击了");
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("B被点击了");
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("C被点击了");
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("D被点击了");
            }
        });
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("E被点击了");
            }
        });
    }
}
