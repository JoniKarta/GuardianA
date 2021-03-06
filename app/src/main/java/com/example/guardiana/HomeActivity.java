package com.example.guardiana;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.guardiana.fragments.FragmentRoad;
import com.example.guardiana.fragments.FragmentSearch;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class HomeActivity extends AppCompatActivity {
    private ChipNavigationBar chipNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        chipNavigationBar = findViewById(R.id.bottom_nav_menu);
        chipNavigationBar.setItemSelected(R.id.bottom_nav_search, true);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentSearch()).commit();
        bottomMenu();
    }
    private void bottomMenu() {
        chipNavigationBar.setOnItemSelectedListener(id -> {
            Fragment fragment;
            if (R.id.bottom_nav_search == id) {
                fragment = new FragmentSearch();
            } else {
                fragment = new FragmentRoad();
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
        });
    }
}