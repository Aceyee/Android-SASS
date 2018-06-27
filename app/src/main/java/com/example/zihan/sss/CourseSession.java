package com.example.zihan.sss;

import android.content.Context;
import android.widget.Button;

/**
 * Created by Zihan on 2018/6/25.
 */
/*
public class CourseSession extends android.support.v7.widget.AppCompatButton{
    private String university;
    private String course;
    private String professor;


    public CourseSession(Context context, String university, String course, String professor) {
        super(context);
        this.professor=professor;
        this.course=course;
        this.university=university;
    }*/
public class CourseSession{
    private int id;
    private String university;
    private String course;
    private String professor;
    public CourseSession(int id, String university, String course, String professor) {
        this.id =id;
        this.professor=professor;
        this.course=course;
        this.university=university;
    }

    public String getUniversity() {
        return university;
    }

    public String getProfessor() {
        return professor;
    }

    public String getCourse() {
        return course;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getId() {
        return id;
    }
}