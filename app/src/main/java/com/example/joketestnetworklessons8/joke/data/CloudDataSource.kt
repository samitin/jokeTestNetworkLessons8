package com.example.joketestnetworklessons8.joke.data

import com.example.joketestnetworklessons8.joke.data.cloud.JokeDto
import com.example.joketestnetworklessons8.joke.domain.data.LoadResult

interface CloudDataSource {

    fun getJoke() : LoadResult


}