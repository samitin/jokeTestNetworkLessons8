package com.example.joketestnetworklessons8.joke.domain

import com.example.joketestnetworklessons8.joke.domain.data.LoadResult

interface LoadResultToJokeResult : LoadResult.Mapper<JokeResult> {
    class Base : LoadResultToJokeResult {
        override fun mapSuccess(category : String,jokeText: String): JokeResult =
            JokeResult.Success("$category \n\n $jokeText")
    }
}