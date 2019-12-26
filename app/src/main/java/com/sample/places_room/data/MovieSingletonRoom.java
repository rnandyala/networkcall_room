package com.sample.places_room.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {MovieEntity.class}, version = 1, exportSchema = false)
public abstract class MovieSingletonRoom extends RoomDatabase {

    private static volatile MovieSingletonRoom mInstance;

    public abstract MovieDao getMovieDao();

    private static final int NUMBER_OF_THREADS = 4;

    public static final ExecutorService databaseExecutor = Executors.newFixedThreadPool(4);


    public static MovieSingletonRoom getInstance(Context mContext) {
        if (mInstance == null) {
            mInstance = Room.databaseBuilder(mContext.getApplicationContext(), MovieSingletonRoom.class, "movie_database1").build();
        }
        return mInstance;
    }


}

