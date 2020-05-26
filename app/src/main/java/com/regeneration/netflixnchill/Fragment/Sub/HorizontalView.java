package com.regeneration.netflixnchill.Fragment.Sub;

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
import androidx.fragment.app.FragmentTransaction;

import com.regeneration.netflixnchill.Class.Item;
import com.regeneration.netflixnchill.R;

import java.util.ArrayList;

public class HorizontalView extends Fragment {
    View view;

    String title;

    public HorizontalView(String title) {
        this.title = title;
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
                    fragmentTransaction.add(R.id.container, fragment);

                    fragmentTransaction.commit();
                }
            }).start();
        }
    }
}
