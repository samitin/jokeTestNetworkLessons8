package com.example.joketestnetworklessons8.joke.data

import com.example.joketestnetworklessons8.joke.data.cloud.JokeDto

interface CloudDataSource {

    fun getJoke() : JokeDto


}