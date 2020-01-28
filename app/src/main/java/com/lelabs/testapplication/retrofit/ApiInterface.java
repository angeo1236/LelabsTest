package com.lelabs.testapplication.retrofit;


import com.lelabs.testapplication.data.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("users")
    Call<List<UserModel>> get_homepage_data();
}
