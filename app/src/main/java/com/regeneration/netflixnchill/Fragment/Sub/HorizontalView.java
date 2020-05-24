package com.regeneration.netflixnchill.Fragment.Sub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.regeneration.netflixnchill.Class.Movie.Movie;
import com.regeneration.netflixnchill.R;

import android.util.Log; // DELETE

public class HorizontalView extends Fragment {
    View view;

    String title;
    Movie[] movies;

    public HorizontalView(String title, Movie[] movies) {
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
        for (Movie m : movies){
            Log.i("", m.toString());
        }
    }
}
