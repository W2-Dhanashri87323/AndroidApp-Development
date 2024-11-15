package com.dhanashri.app;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface API {
    @GET("/users")
    Call<JsonObject> getAllUsers();

    @POST("/users")
    Call<JsonObject> addUser(@Body User user);

    @PUT("/users/{id}")
    Call<JsonObject> updateUser(@Body User user, @Path("id") int id);


}
