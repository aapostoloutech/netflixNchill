package com.regeneration.netflixnchill.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.regeneration.netflixnchill.Class.Item;
import com.regeneration.netflixnchill.Class.JSON.JsonCallback;
import com.regeneration.netflixnchill.Class.JSON.JsonModelTrending;
import com.regeneration.netflixnchill.Class.JSON.JsonModelTrendingAll;
import com.regeneration.netflixnchill.Class.Movie.JsonModelDiscoverMovie;
import com.regeneration.netflixnchill.Class.Movie.Movie;
import com.regeneration.netflixnchill.Class.TMDB;
import com.regeneration.netflixnchill.Class.Utils;
import com.regeneration.netflixnchill.Fragment.Sub.HorizontalView;
import com.regeneration.netflixnchill.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeTab extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_home, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String url;


        // Add Trending Horizontal View & Trending Category Horizontal View
        // - URL / Query
        url = "https://api.themoviedb.org/3/trending/all/week?api_key=" + Utils.api_key;
        // - Create Horizontal View - Trending
        final Fragment fragmentTrending = new HorizontalView("Trending");
        getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.trending_container, fragmentTrending, "trending")
                .commit();
        // - Create Horizontal View - Trending Categories
        final Fragment fragmentTrendingCategories = new HorizontalView("Trending Categories");
        getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.trending_category_container, fragmentTrendingCategories, "trending_categories")
                .commit();

        // - (Async) API Request
        new TMDB(this.getContext(), url, new JsonModelTrending(), new JsonCallback() {
            public void call(JsonModelTrending model) throws Exception {
                // Trending
                ArrayList<Item> items = new ArrayList<>();
                for (JsonModelTrendingAll m : model.getResults()) {
                    items.add(new Item(m.getId(), m.getPoster_path()));
                }
                // - Fill with Images
                ((HorizontalView) fragmentTrending).fillView(items);


                // Categories
                HashMap<Integer, Integer> genres = new HashMap<>();
                for (JsonModelTrendingAll m : model.getResults()) {
                    for (int g : m.getGenre_ids()) {
                        genres.put(g, genres.containsKey(g) ? genres.get(g) + 1 : 1);
                    }
                }
                ArrayList<Integer> trending_genre = new ArrayList<>();
                while (genres.size() > 0) {
                    int maxV = -1;
                    int maxK = -1;
                    for (int key : genres.keySet()) {
                        if (genres.get(key) > maxV) {
                            maxV = genres.get(key);
                            maxK = key;
                        }
                    }
                    trending_genre.add(maxK);

                    genres.remove(maxK);
                }

                Utils.sos();
                Log.i("", trending_genre.toString());
                Utils.sos();
            }
        });


        // Add Popular Horizontal View
        // - URL / Query
        url = "https://api.themoviedb.org/3/discover/movie?api_key=" + Utils.api_key + "&sort_by=popularity.desc";
        // - Create Horizontal View - Trending
        final Fragment fragmentPopular = new HorizontalView("Popular");
        getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.popular_container, fragmentPopular, "trending")
                .commit();
        // - (Async) API Request
        TMDB discover = new TMDB(this.getContext(), url, new JsonModelDiscoverMovie(), new JsonCallback() {
            public void call(JsonModelDiscoverMovie model) throws Exception {
                // Popular
                ArrayList<Item> items = new ArrayList<>();
                for (Movie m : model.getResults()) {
                    items.add(new Item(m.getId(), m.getPoster_path()));
                }

                // - Fill with Images
                ((HorizontalView) fragmentPopular).fillView(items);
            }
        });
    }
}