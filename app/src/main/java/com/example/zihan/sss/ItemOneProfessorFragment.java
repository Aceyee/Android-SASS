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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ItemOneProfessorFragment extends Fragment {
    private static User user;
    static View mview;
    Button btn_create;
    static ArrayList<CourseSession> courselist;
    static CourseListAdapter adapter;

    public static ItemOneProfessorFragment newInstance() {
        ItemOneProfessorFragment fragment = new ItemOneProfessorFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item_one_professor, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        user=MainActivity.getUser();
        mview=view;
        loadData();
        ListView lv = (ListView)view.findViewById(R.id.courselist_prof);
        adapter = new CourseListAdapter(getContext(), R.layout.adapter_view_layout, courselist);
        lv.setAdapter(adapter);
        btn_create = (Button)view.findViewById(R.id.btn_create);
        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), CreateSession.class));
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
