package com.example.joketestnetworklessons8.joke.data

import com.example.joketestnetworklessons8.core.error.HandleError
import com.example.joketestnetworklessons8.joke.data.cloud.JokeDto
import com.example.joketestnetworklessons8.joke.domain.data.JokeRepository
import com.example.joketestnetworklessons8.joke.domain.data.LoadResult

class BaseJokeRepository(
    private val cloudDataSource: CloudDataSource,
) : JokeRepository {
    override suspend fun getJoke(): LoadResult {
        return cloudDataSource.getJoke()
    }

}