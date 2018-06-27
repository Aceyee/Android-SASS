package com.example.zihan.sss;

/**
 * Created by Zihan on 2018/6/26.
 */

public class User {
    private String university;
    private String username;
    private String roll;
    private String id;

    public User(){

    }
    public User(String university, String username, String roll, String id){
        this.university=university;
        this.username=username;
        this.roll=roll;
        this.id=id;
    }

    public String getUniversity() {
        return university;
    }

    public String getId() {
        return id;
    }

    public String getRoll() {
        return roll;
    }

    public String getUsername() {
        return username;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isStudent(){
        return roll.equals("Student");
    }

    public boolean isProfessor(){
        return roll.equals("Professor");
    }
}
