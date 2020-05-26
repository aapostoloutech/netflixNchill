package com.regeneration.netflixnchill.Fragment.Sub;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.regeneration.netflixnchill.Class.Item;
import com.regeneration.netflixnchill.Class.Movie.Movie;
import com.regeneration.netflixnchill.R;
import com.squareup.picasso.Picasso;

public class HorizontalViewImage extends Fragment {
    View view;

    String src;

    public HorizontalViewImage(Item i) {
        this.src = i.getPoster_path();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.template_horizontalview_image, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Set Image src
        ImageView image = view.findViewById(R.id.horizontalview_image);
        Picasso.get().load("https://image.tmdb.org/t/p/w500/" + src).into(image);
    }
}
