package com.example.zihan.sss;

/**
 * Created by Zihan on 2018/5/5.
 */

import android.content.Intent;
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

import java.util.ArrayList;

public class ItemOneStudentFragment extends Fragment {
    Button btn_search;
    static ArrayList<CourseSession> courselist = new ArrayList<>();
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
        ListView lv = (ListView)view.findViewById(R.id.courselist);
        adapter = new CourseListAdapter(getContext(), R.layout.adapter_view_layout, courselist);
        lv.setAdapter(adapter);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), SearchSession.class));
            }
        });
    }

    public static void addItems(CourseSession courseSession) {
        courselist.add(courseSession);
        adapter.notifyDataSetChanged();
    }
}
