package com.sample.places_room.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MovieDao {
    @Insert
    void insertName(MovieEntity mMovieEntity);
    // said no to live data as I am bored ..
    @Query("SELECT * FROM movie_details")
    List<MovieEntity> getAllMovies();
}

