package com.evotech.apptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public static final String BASE_URL = "https://api.twitter.com/2/";
    private UserCall users;
    private TwitterCall twitterCall;
    private static final String token = "AAAAAAAAAAAAAAAAAAAAAAFMMwEAAAAAC%2Bcb%2BxLmK6BJFT4PpRQshyUxrvc%3DJdxzgoNYCSh2NzgJ4Fv3QXynODYSxyqPqZHKwL9wPAJIq4D8iO";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.text_view);

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        twitterCall = retrofit.create(TwitterCall.class);
        twitterCall.getUser("Bearer "+token,"1275828087666679809", "").enqueue(new Callback<TwitterCall>(){
            @Override
            public void onResponse(Call<TwitterCall> call, Response<TwitterCall> response) {
                Log.d("TES", ": "+response);
            }

            @Override
            public void onFailure(Call<TwitterCall> call, Throwable t) {
                Log.d("TES", ": "+t.getCause());
            }
        });

//        github user example
//        users = retrofit.create(UserCall.class);
//        users.getUser("sudo-dev-urandom").enqueue(new Callback<Users>() {
//            @Override
//            public void onResponse(Call<Users> call, Response<Users> response) {
//                Log.d("TES", ": "+response.body().getUrl());
//                textView.setText(response.body().getUrl());
//            }
//
//            @Override
//            public void onFailure(Call<Users> call, Throwable t) {
//                Log.d("DATA", ": "+t.getCause());
//            }
//        });
    }
}