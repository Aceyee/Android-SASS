package com.squareink.zihan.sss;

/**
 * Created by Zihan on 2018/6/25.
 */

public class CourseSession {
    private int id;                 // course id
    private String university;      // university of this course
    private String course;          // course name
    private String professor;       // professor of this course

    /**
     * @param id
     * @param university
     * @param course
     * @param professor  Instantiate a CourseSession given above parameters
     */
    public CourseSession(int id, String university, String course, String professor) {
        this.id = id;
        this.professor = professor;
        this.course = course;
        this.university = university;
    }

    // get*() and set*() methods
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