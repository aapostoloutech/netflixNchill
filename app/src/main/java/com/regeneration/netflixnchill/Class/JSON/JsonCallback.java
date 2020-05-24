package com.regeneration.netflixnchill.Class.JSON;

import android.util.Log;

import com.regeneration.netflixnchill.Class.Movie.JsonModelDiscoverMovie;

import java.util.concurrent.Callable;

public class JsonCallback<T> implements Callable {
    public String call() throws Exception {
        return null;
    }
    public void call(JsonModel model) throws Exception {
        Log.i("","Default call JsonModel");

        if (model.getClass() == JsonModelDiscoverMovie.class){ call((JsonModelDiscoverMovie) model); } // <- Πολύ κακό
    }
    public void call(JsonModelDiscoverMovie model) throws Exception {
        Log.i("","Default call JsonModelM");
    }
}
