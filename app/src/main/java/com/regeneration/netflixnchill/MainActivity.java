package com.regeneration.netflixnchill;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import com.regeneration.netflixnchill.Class.TMDB;
import com.regeneration.netflixnchill.Class.Utils;

import com.regeneration.netflixnchill.Fragment.HomeTab;
import com.regeneration.netflixnchill.Fragment.LoginTab;
import com.regeneration.netflixnchill.Fragment.MoviesTab;
import com.regeneration.netflixnchill.Fragment.ProfileTab;
import com.regeneration.netflixnchill.Fragment.SearchTab;
import com.regeneration.netflixnchill.Fragment.SeriesTab;

import java.sql.SQLOutput;

public class MainActivity extends AppCompatActivity {
    ChipNavigationBar navigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationBar = findViewById(R.id.nav_bar);

        if (savedInstanceState == null){
            navigationBar.setItemSelected(R.id.home, true);
            HomeTab homeTab = new HomeTab();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, homeTab).commit();
        }

        navigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int id) {
                Fragment fragment = null;
                switch (id){
                    case R.id.home:
                        fragment = new HomeTab();
                        break;
                    case R.id.movies:
                        fragment = new MoviesTab();
                        break;
                    case R.id.search:
                        fragment = new SearchTab();
                        break;
                    case R.id.series:
                        fragment = new SeriesTab();
                        break;
                    case R.id.profile:
                        fragment = Utils.isLoggedin() ? new ProfileTab() : new LoginTab();
                        break;
                    default:
                        fragment = new HomeTab();
                }

                if (fragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
                }
            }
        });
    }
}