package com.regeneration.netflixnchill.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.regeneration.netflixnchill.Class.JsonCallback;
import com.regeneration.netflixnchill.Class.JsonModel;
import com.regeneration.netflixnchill.Class.Movie.JsonModelM;
import com.regeneration.netflixnchill.Class.Movie.Movie; // DELETE ?

import com.regeneration.netflixnchill.Class.TMDB;
import com.regeneration.netflixnchill.Class.Utils;
import com.regeneration.netflixnchill.Fragment.Sub.HorizontalView;

import com.regeneration.netflixnchill.R;

import java.util.concurrent.Callable;

public class ProfileTab extends Fragment {
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_profile, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Add Favorites Horizontal View
        Movie[] movies = {};
        Fragment fragment = new HorizontalView("Favorites", movies);
        fragmentTransaction.add(R.id.favorites, fragment, "favorites");

        // DEV - Testing
        Movie[] movies2 = {};
        Fragment fragment2 = new HorizontalView("Favorites", movies);
        fragmentTransaction.add(R.id.favorites, fragment2, "favorites 2");

        fragmentTransaction.commit();


        String url = "https://api.themoviedb.org/3/discover/movie?api_key=" + Utils.api_key + "&sort_by=popularity.desc";
        TMDB test = new TMDB(this.getContext(), url, new JsonModelM(), new JsonCallback() {
            @Override
            public Void call(JsonModelM model) throws Exception {
                Log.i("", model.getPage() + "8=======================================================D ~~");

                return null;
            }
        });
    }
}
