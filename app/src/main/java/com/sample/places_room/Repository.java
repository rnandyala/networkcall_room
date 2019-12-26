package com.sample.places_room;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.sample.places_room.data.MovieDao;
import com.sample.places_room.data.MovieEntity;
import com.sample.places_room.data.MovieSingletonRoom;
import com.sample.places_room.network.*;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

class Repository {
    List<MovieEntity> mMovieEntity;
    ApiInterface IApiInterface;
    Response mResponse;
    MovieDao IMovieDao;
    boolean isFetch = true;
    private LiveData<MovieEntity> mMovie;

    Repository(Context mContext) {
        IApiInterface = SingletonService.getRetrofit2().create(ApiInterface.class);
        initRoom(mContext);
        getNetworkResponse(isFetch);
    }

    private void initRoom(Context mContext) {
        MovieSingletonRoom database = MovieSingletonRoom.getInstance(mContext);
        IMovieDao = database.getMovieDao();
    }

    private void insert(final MovieEntity mMovieData) {
        MovieSingletonRoom.databaseExecutor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        IMovieDao.insertName(mMovieData);

                        getmMovie();
                    }
                });
    }

    private Response getNetworkResponse(boolean isFetch) {
        IApiInterface.getMovies().enqueue(
                new Callback<Response>() {
                    @Override
                    public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                        mResponse = response.body();
                        insert(new MovieEntity(mResponse.getId(), mResponse.getDescription()));
                    }

                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {
                        t.getMessage();
                    }
                });
        return mResponse;
    }

    List<MovieEntity> getmMovie() {
        MovieSingletonRoom.databaseExecutor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        mMovieEntity = IMovieDao.getAllMovies();
                    }
                }
        );
        return mMovieEntity;
    }

}
