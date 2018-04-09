package com.example.nikma.firebasedatabase;

/**
 * Created by nikma on 4/7/2018.
 */

public class Artist {
    String id;
    String name;
    String genre;

    public Artist(String id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }
    public Artist(){

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }
}
