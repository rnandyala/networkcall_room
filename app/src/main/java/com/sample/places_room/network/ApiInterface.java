package com.sample.places_room.network;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    //https://ghibliapi.herokuapp.com/films/5fdfb320-2a02-49a7-94ff-5ca418cae602
    @GET("films/5fdfb320-2a02-49a7-94ff-5ca418cae602")
    Call<Response> getMovies();
}
