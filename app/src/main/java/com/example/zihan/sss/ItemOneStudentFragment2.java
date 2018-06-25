package com.example.zihan.sss;

/**
 * Created by Zihan on 2018/5/5.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ItemOneStudentFragment2 extends Fragment {
    Button btn_search;
    //LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS
    static ArrayList<String> listItems=new ArrayList<String>();

    //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW
    static ArrayAdapter<String> adapter;
    //RECORDING HOW MANY TIMES THE BUTTON HAS BEEN CLICKED
    int clickCounter=0;

    public static ItemOneStudentFragment2 newInstance() {
        ItemOneStudentFragment2 fragment = new ItemOneStudentFragment2();
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
        adapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,listItems);
        lv.setAdapter(adapter);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), SearchSession.class));
            }
        });

//        btn_search.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                addItems(view);
//            }
//        });
    }
    //METHOD WHICH WILL HANDLE DYNAMIC INSERTION
    public static void addItems(String string) {
        listItems.add(string);
        adapter.notifyDataSetChanged();
    }
}
