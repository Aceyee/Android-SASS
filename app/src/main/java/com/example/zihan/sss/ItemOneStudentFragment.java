package com.example.zihan.sss;

/**
 * Created by Zihan on 2018/5/5.
 */

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ItemOneStudentFragment extends Fragment {
    static User user;
    Button btn_search;
    Button btn_save;
    static View mview;
    static ArrayList<CourseSession> courselist;
    static CourseListAdapter adapter;

    public static ItemOneStudentFragment newInstance() {
        ItemOneStudentFragment fragment = new ItemOneStudentFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item_one_student, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        btn_search = (Button)view.findViewById(R.id.btn_search);
        btn_save = (Button)view.findViewById(R.id.btn_save);
        user = MainActivity.getUser();
        mview = view;
        loadData();
        //view.getContext().getSharedPreferences("shared preference", 0).edit().clear().commit();
        ListView lv = (ListView)view.findViewById(R.id.courselist);
        adapter = new CourseListAdapter(getContext(), R.layout.adapter_view_layout, courselist);
        lv.setAdapter(adapter);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), SearchSession.class));
            }
        });
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });
    }

    private static void saveData() {
        SharedPreferences sharedPreferences = mview.getContext().getSharedPreferences("shared preference", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(courselist);
        editor.putString(user.getUsername(), json);
        editor.apply();
    }

    private void loadData(){
        SharedPreferences sharedPreferences = getView().getContext().getSharedPreferences("shared preference", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(user.getUsername(), null);
        Type type = new TypeToken<ArrayList<CourseSession>>() {}.getType();
        courselist = gson.fromJson(json,type);

        if(courselist==null){
            courselist=new ArrayList<>();
        }
    }

    public static void addItems(CourseSession courseSession) {
        courselist.add(courseSession);
        adapter.notifyDataSetChanged();
        saveData();
    }
}
