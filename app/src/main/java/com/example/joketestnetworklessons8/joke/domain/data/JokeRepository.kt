package com.example.joketestnetworklessons8.joke.domain.data

interface JokeRepository {

    fun getJoke() : LoadResult
}