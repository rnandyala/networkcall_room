package com.sample.places_room;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Observer;

public class MainActivity extends AppCompatActivity {

    //  https://developers.google.com/places/web-service/photos
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Repository mRepository = new Repository(this);
        mRepository.getmMovie();
    }
}
