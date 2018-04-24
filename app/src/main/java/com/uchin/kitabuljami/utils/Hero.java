package com.uchin.kitabuljami.utils;

/**
 * Created by Mukhlasin on 11/9/2017.
 */

public class Hero {
    private String id;
    private String name;
    private String email;

    public Hero(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
