package com.squareink.zihan.sss;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;              // navigation buttons
    private static User user;                               // current logged user

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // bind view in the activity_main.xml
        bottomNavigationView = findViewById(R.id.navigation);

        // set navigation buttons
        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.action_item1:
                                if (user.getRole().equals("Student")) {
                                    selectedFragment = ItemOneStudentFragment.newInstance();
                                } else if (user.getRole().equals("Professor")) {
                                    selectedFragment = ItemOneProfessorFragment.newInstance();
                                }
                                break;
                            case R.id.action_item2:
                                selectedFragment = ItemTwoFragment.newInstance();
                                break;
                            case R.id.action_item3:
                                selectedFragment = ItemThreeFragment.newInstance();
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_layout, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });

        //Manually displaying the first fragment - one time only
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (user.getRole().equals("Student")) {
            transaction.replace(R.id.frame_layout, ItemOneStudentFragment.newInstance());
        } else if (user.getRole().equals("Professor")) {
            transaction.replace(R.id.frame_layout, ItemOneProfessorFragment.newInstance());
        }
        transaction.commit();
    }

    /**
     * @return get current user info
     */
    public static User getUser() {
        return user;
    }

    /**
     * @param user set current user info
     */
    public static void setUser(User user) {
        MainActivity.user = user;
    }
}