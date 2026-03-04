package org.utils;

import org.models.*;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Context {
    private HashMap<String, Movie> collection;
    private LocalDateTime creationDate;

    public Context() {
        collection = new HashMap<>();
        load(System.getenv("PATH_TO_COLLECTION"));
    }
    //TODO
    public void load(String path) {

    }

    public void clear() {collection.clear();}

    public void add(String key, Movie movie) {collection.put(key, movie);}

    public void show() {
        StringBuilder builder = new StringBuilder();
        for (var movie : collection.values()) {builder.append(movie.toString() + "\n");}
        System.out.println(builder.toString());
    }


    //TODO
    @Override
    public String toString() {
        return "";
    }
}
