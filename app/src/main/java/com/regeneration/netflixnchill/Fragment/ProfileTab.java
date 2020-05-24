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

import com.regeneration.netflixnchill.Class.JSON.JsonCallback;
import com.regeneration.netflixnchill.Class.Movie.JsonModelDiscoverMovie;
import com.regeneration.netflixnchill.Class.Movie.Movie; // DELETE ?

import com.regeneration.netflixnchill.Class.TMDB;
import com.regeneration.netflixnchill.Class.Utils;
import com.regeneration.netflixnchill.Fragment.Sub.HorizontalView;

import com.regeneration.netflixnchill.R;

import java.util.ArrayList;

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
        ArrayList<Movie> movies = new ArrayList<>();

        Fragment fragment = new HorizontalView("Favorites", movies);
        fragmentTransaction.add(R.id.favorites, fragment, "favorite_movies");

        // DEV - DELETE
        ArrayList<Movie> movies2 = new ArrayList<>();
        String[] src = {"/xBHvZcjRiWyobQ9kxBhO6B2dtRI.jpg","/zG2l9Svw4PTldWJAzC171Y3d6G8.jpg","/8WUVHemHFH2ZIP6NWkwlHWsyrEL.jpg","/aQvJ5WPzZgYVDrxLX4R6cLJCEaQ.jpg","/iZf0KyrE25z1sage4SYFLCCrMi9.jpg","/h4VB6m0RwcicVEZvzftYZyKXs6K.jpg","/y95lQLnuNKdPAzw9F9Ab8kJ80c3.jpg","/qa6HCwP4Z15l3hpsASz3auugEW6.jpg","/wlfDxbGEsW58vGhFljKkcR5IxDj.jpg","/niyXFhGIk4W2WTcX2Eod8vx2Mfe.jpg","/pjeMs3yqRmFL3giJy4PMXWZTTPa.jpg","/9gk7adHYeDvHkCSEqAvQNLV5Uge.jpg","/c01Y4suApJ1Wic2xLmaq1QYcfoZ.jpg","/A2YlIrzypvhS3vTFMcDkG3xLvac.jpg","/f4aul3FyD3jv3v4bul1IrkWZvzq.jpg","/db32LaOibwEliAmSL2jjDF6oDdj.jpg","/7IiTTgloJzvGI1TAYymCfbfl3vT.jpg","/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg","/5EufsDwXdY2CVttYOk2WtYhgKpa.jpg","/7GsM4mtM0worCtIVeiQt28HieeN.jpg"};

        for (String s : src){
            Movie m = new Movie();
            m.setPoster_path(s);

            movies2.add(m);
        }

        Fragment fragment2 = new HorizontalView("Testing", movies2);
        fragmentTransaction.add(R.id.favorites, fragment2);
        // ------------

        fragmentTransaction.commit();


        String url = "https://api.themoviedb.org/3/discover/movie?api_key=" + Utils.api_key + "&sort_by=popularity.desc";
        new TMDB(this.getContext(), url, new JsonModelDiscoverMovie(), new JsonCallback() {
            public void call(JsonModelDiscoverMovie model) throws Exception {
                Log.i("", model.getPage() + " =======================================================");
            }
        });
    }
}
