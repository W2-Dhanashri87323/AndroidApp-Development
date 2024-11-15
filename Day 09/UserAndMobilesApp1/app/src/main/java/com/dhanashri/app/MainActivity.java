package com.dhanashri.app;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    public static final String BASE_URL = "http://192.168.251.19:8080";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        addUser();
    }

    @Override
    protected void onStart() {
        super.onStart();
        getAllUsers();
    }

    public void getAllUsers() {
        new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(API.class)
                .getAllUsers()
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                        JsonObject object = response.body();
                        if (object.get("status").getAsString().equals("success")) {
                            JsonArray array = object.get("data").getAsJsonArray();
                            for (JsonElement element : array) {
                                int id = element.getAsJsonObject().get("id").getAsInt();
                                String name = element.getAsJsonObject().get("name").getAsString();
                                String mobile = element.getAsJsonObject().get("mobile").getAsString();
                                Log.e("response", id + "-" + name + "-" + mobile);

                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable throwable) {
                        Log.e("onFailure: ", String.valueOf(throwable));
                        Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void addUser() {
        User user = new User(0, "Dhanashri", "dhanashri@gmail.com", "dhanu", "9876543210");
        new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(API.class)
                .addUser(user)
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable throwable) {
                        Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void updateUser(){
     User user = new User(0,"Raj","Raj@gmail.com","raj","123456789");
     new Retrofit.Builder()
             .baseUrl(BASE_URL)
             .addConverterFactory(GsonConverterFactory.create())
             .build()
             .create(API.class)
             .addUser(user)
             .enqueue(new Callback<JsonObject>() {
                 @Override
                 public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                     
                 }

                 @Override
                 public void onFailure(Call<JsonObject> call, Throwable throwable) {

                 }
             });

    }

}