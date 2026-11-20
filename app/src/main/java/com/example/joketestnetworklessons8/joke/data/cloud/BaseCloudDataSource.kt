package com.example.joketestnetworklessons8.joke.data.cloud

import com.example.joketestnetworklessons8.joke.data.CloudDataSource

class BaseCloudDataSource (
    private val service: JokeService
): CloudDataSource {
    override fun getJoke(): JokeDto {
        var joke : JokeDto ?= null
        service.getJoke(
            object : ServiceCallback {
                override fun returnSuccess(category: String, data: String) {
                    joke = JokeDto(category = category, setup = data)
                }
            }
        )
        return joke!!
    }
}