package com.regeneration.netflixnchill.Class.Series;

public class Series {
    private String original_name;
    private int[] genre_ids;
    private String name;
    private float popularity;
    private String[] origin_country;
    private int vote_count;
    private String first_ait_date;
    private String backdrop_path;
    private String original_language;
    private int id;
    private float vote_average;
    private String overview;
    private String poster_path;

    public Series(String original_name, int[] genre_ids, String name, float popularity, String[] origin_country, int vote_count, String first_ait_date, String backdrop_path, String original_language, int id, float vote_average, String overview, String poster_path) {
        this.original_name = original_name;
        this.genre_ids = genre_ids;
        this.name = name;
        this.popularity = popularity;
        this.origin_country = origin_country;
        this.vote_count = vote_count;
        this.first_ait_date = first_ait_date;
        this.backdrop_path = backdrop_path;
        this.original_language = original_language;
        this.id = id;
        this.vote_average = vote_average;
        this.overview = overview;
        this.poster_path = poster_path;
    }
}
