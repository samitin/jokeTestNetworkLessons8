package com.example.joketestnetworklessons8.joke.data.cloud

import retrofit2.Call
import retrofit2.http.GET

interface JokeService {
    @GET("/joke/Any?type=single&safe_mode")
    fun getJoke() : Call<JokeDto>
}