package com.regeneration.netflixnchill.Class;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

public class TMDB {
    private JsonCallback callback;
    private JsonModel model;

    public TMDB(Context context, String url, JsonModel model, JsonCallback callback) {
        this.model = model;
        this.callback = callback;

        RequestJSON(context, url);
    }

    public void RequestJSON(Context context, String url) {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(context);

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        handleResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                handleResponseError(new String(error.networkResponse.data));
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    public void handleResponse(String response) {
        JsonModel model = new Gson().fromJson(response, this.model.getClass());

        try {
            callback.call(model);
        } catch (Exception e){}
    }

    public void handleResponseError(String error) {
        JsonErrorModel json = new Gson().fromJson(error, JsonErrorModel.class);
    }
}
