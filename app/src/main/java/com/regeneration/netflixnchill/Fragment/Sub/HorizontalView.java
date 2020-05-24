package com.regeneration.netflixnchill.Fragment.Sub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.regeneration.netflixnchill.Class.Movie.Movie;
import com.regeneration.netflixnchill.R;

import android.util.Log; // DELETE

import java.util.ArrayList;

public class HorizontalView extends Fragment {
    View view;

    String title;
    ArrayList<Movie> movies = new ArrayList<>();

    public HorizontalView(String title, ArrayList<Movie> movies) {
        this.title = title;
        this.movies = movies;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.template_horizontalview, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Set Title
        TextView text_title = view.findViewById(R.id.title);
        text_title.setText(title);

        // Add Images
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        for (Movie m : movies){
            // Add Favorites Horizontal View
            Fragment fragment = new HorizontalViewImage(m);
            fragmentTransaction.add(R.id.image_container, fragment);
        }

        fragmentTransaction.commit();
    }
}
