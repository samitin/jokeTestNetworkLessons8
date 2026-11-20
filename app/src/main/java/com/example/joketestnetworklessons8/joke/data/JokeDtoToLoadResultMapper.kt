package com.example.joketestnetworklessons8.joke.data

import com.example.joketestnetworklessons8.joke.data.cloud.JokeDto
import com.example.joketestnetworklessons8.joke.domain.data.LoadResult

class JokeDtoToLoadResultMapper : JokeDto.Mapper {
    override fun map(category : String,jokeText: String): LoadResult {
        return LoadResult.Base(category,jokeText)
    }
}