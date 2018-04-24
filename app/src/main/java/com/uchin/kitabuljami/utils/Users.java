package com.uchin.kitabuljami.utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Mukhlasin on 2/23/2018.
 */

public class Users {
    @SerializedName("users")
    @Expose
    private ArrayList<User> users = null;

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

}
