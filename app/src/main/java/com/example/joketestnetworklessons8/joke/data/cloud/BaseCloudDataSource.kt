package com.example.joketestnetworklessons8.joke.data.cloud

import com.example.joketestnetworklessons8.core.error.HandleError
import com.example.joketestnetworklessons8.joke.data.CloudDataSource
import com.example.joketestnetworklessons8.joke.domain.data.LoadResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BaseCloudDataSource (
    private val service: JokeService,
    private val mapper: JokeDto.Mapper,
    private val handleError: HandleError
): CloudDataSource {

    constructor(mapper: JokeDto.Mapper,
                handleError: HandleError) : this(
        Retrofit.Builder()
            .baseUrl("https://v2.jokeapi.dev")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(JokeService::class.java),
        mapper,
        handleError
    )
    override fun getJoke(): LoadResult {
        try {
            val data = service.getJoke().execute()
            val listJokeDto = data.body()!!
            return listJokeDto.map(mapper)
        }catch (e : Exception){
            throw handleError.handle(e)
        }
    }
}