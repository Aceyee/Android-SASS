package com.example.zihan.sss;

import android.content.Context;
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
        String university = getItem(position).getUniversity();
        String course = getItem(position).getCourse();
        String professor = getItem(position).getProfessor();

        CourseSession courseSession = new CourseSession(university,course,professor);
        LayoutInflater inflater = LayoutInflater.from(mcontext);
        convertView = inflater.inflate(mResource,parent,false);

        TextView tv_university = (TextView)convertView.findViewById(R.id.list_university);
        TextView tv_professor = (TextView)convertView.findViewById(R.id.list_professor);
        TextView tv_course = (TextView)convertView.findViewById(R.id.list_course);

        tv_university.setText(university);
        tv_course.setText(course);
        tv_professor.setText(professor);

        return convertView;
    }
}
