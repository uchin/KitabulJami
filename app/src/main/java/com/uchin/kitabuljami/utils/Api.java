package com.uchin.kitabuljami.utils;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Mukhlasin on 11/8/2017.
 */

public interface Api {
    //String BASE_URL = "https://simplifiedcoding.net/demos/";
    String BASE_URL = "http://coreapp.umy.ac.id/kampretos/public/";
    @GET("users")
    Call<List<Users>> getUsers();
}
