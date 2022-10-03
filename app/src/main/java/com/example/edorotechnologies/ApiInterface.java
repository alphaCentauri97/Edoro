package com.example.edorotechnologies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiInterface {

    String BASE_URL = "https://reqres.in/api/";

    @GET("users")
    Call<ListClass> getData();



}
