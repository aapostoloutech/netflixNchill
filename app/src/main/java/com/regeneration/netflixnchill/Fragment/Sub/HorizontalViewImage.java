package com.regeneration.netflixnchill.Fragment.Sub;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.regeneration.netflixnchill.Class.Item;
import com.regeneration.netflixnchill.R;
import com.squareup.picasso.Picasso;

public class HorizontalViewImage extends Fragment {
    String src;

    public HorizontalViewImage(Item i) {
        this.src = i.getPoster_path();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.template_horizontalview_image, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set Image src
        ImageView image = getView().findViewById(R.id.horizontalview_image);
        Picasso.get().load("https://image.tmdb.org/t/p/w500/" + src).into(image);
    }
}
