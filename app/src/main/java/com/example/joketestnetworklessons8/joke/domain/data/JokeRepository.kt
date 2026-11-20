package com.example.joketestnetworklessons8.joke.domain.data

interface JokeRepository {

    suspend fun getJoke() : LoadResult
}