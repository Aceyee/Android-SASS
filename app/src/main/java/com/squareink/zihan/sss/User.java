package com.squareink.zihan.sss;

/**
 * Created by Zihan on 2018/6/26.
 */

public class User {
    private String username;        // user name
    private String passwd;          // password
    private String university;      // university
    private String roll;            // student ? professor
    private String email;           // email address
    private String studentNO;       // student number

    /**
     * @param username
     * @param passwd
     * @param university
     * @param roll
     * @param email
     * @param studentNO  Instantiate a new User given above parameter
     */
    public User(String username, String passwd, String university, String roll, String email, String studentNO) {
        this.username = username;
        this.passwd = passwd;
        this.university = university;
        this.roll = roll;
        this.email = email;
        this.studentNO = studentNO;
    }

    // below are get*() and set*() methods
    public String getUsername() {
        return username;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getUniversity() {
        return university;
    }

    public String getRoll() {
        return roll;
    }

    public String getEmail() {
        return email;
    }

    public String getStudentNO() {
        return studentNO;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStudentNO(String studentNO) {
        this.studentNO = studentNO;
    }

    public boolean isStudent() {
        return roll.equals("Student");
    }

    public boolean isProfessor() {
        return roll.equals("Professor");
    }


    /**
     * @return the user statement
     */
    @Override
    public String toString() {
        return username + " " + university + " " + email;
    }
}
