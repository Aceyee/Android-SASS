package com.example.zihan.sss;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zihan on 2018/6/25.
 */

public class CourseListAdapter extends ArrayAdapter<CourseSession> {
    private Context mcontext;
    int mResource;
    public CourseListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<CourseSession> objects) {
        super(context, resource, objects);
        mcontext=context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final int id = getItem(position).getId();
        final String university = getItem(position).getUniversity();
        final String course = getItem(position).getCourse();
        String professor = getItem(position).getProfessor();

        LayoutInflater inflater = LayoutInflater.from(mcontext);
        convertView = inflater.inflate(mResource,parent,false);

        TextView tv_university = (TextView)convertView.findViewById(R.id.list_university);
        TextView tv_professor = (TextView)convertView.findViewById(R.id.list_professor);
        final TextView tv_course = (TextView)convertView.findViewById(R.id.list_course);

        tv_university.setText(university);
        tv_course.setText(course);
        tv_professor.setText(professor);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Punch.class);
                intent.putExtra("coursename", course);
                intent.putExtra("courseid", id);
                view.getContext().startActivity(intent);
            }
        });

        return convertView;
    }
}
