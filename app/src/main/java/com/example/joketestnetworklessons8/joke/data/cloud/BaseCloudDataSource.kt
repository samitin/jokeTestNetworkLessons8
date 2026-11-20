package com.example.joketestnetworklessons8.joke.data.cloud

import com.example.joketestnetworklessons8.joke.data.CloudDataSource

class BaseCloudDataSource (
    private val service: JokeService
): CloudDataSource {
    override fun getJoke(): JokeDto {
        var joke : JokeDto ?= null
        service.getJoke(
            object : ServiceCallback {
                override fun returnSuccess(jokeDto: JokeDto) {
                    joke = jokeDto
                }
            }
        )
        return joke!!
    }
}