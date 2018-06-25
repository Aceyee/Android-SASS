package com.example.zihan.sss;

/**
 * Created by Zihan on 2018/6/25.
 */

public class CourseSession {
    private String university;
    private String course;
    private String professor;

    public CourseSession(String university, String course, String professor){
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
}
