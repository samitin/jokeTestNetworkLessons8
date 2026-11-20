package com.example.joketestnetworklessons8.joke.data.cloud

interface JokeService {
    fun getJoke(callback: ServiceCallback)
}
interface ServiceCallback{
    fun returnSuccess(jokeDto: JokeDto)
}