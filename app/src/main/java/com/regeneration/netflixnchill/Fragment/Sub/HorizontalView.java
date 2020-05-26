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

import com.regeneration.netflixnchill.Class.Item;
import com.regeneration.netflixnchill.R;

import java.util.ArrayList;

public class HorizontalView extends Fragment {
    String title;
    String position = null;

    public HorizontalView(String title) {
        this.title = title;
    }
    public HorizontalView(String title, String position) {
        this.title = title;
        this.position = position;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.template_horizontalview, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set Title
        TextView text_title = getView().findViewById(R.id.title);
        text_title.setText(title);

        if (position != null){
            if (position == "right") {
                text_title.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
            }
        }
    }

    public void fillView(ArrayList<Item> items){
        for (final Item i : items){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    FragmentManager fragmentManager = getChildFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    // Add Favorites Horizontal View
                    Fragment fragment = new HorizontalViewImage(i);
                    fragmentTransaction.add(R.id.image_container, fragment);

                    fragmentTransaction.commit();
                }
            }).start();
        }
    }
}
