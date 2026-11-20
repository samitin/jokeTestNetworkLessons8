package com.example.joketestnetworklessons8.joke.data

import com.example.joketestnetworklessons8.core.error.HandleError
import com.example.joketestnetworklessons8.joke.data.cloud.JokeDto
import com.example.joketestnetworklessons8.joke.domain.data.JokeRepository
import com.example.joketestnetworklessons8.joke.domain.data.LoadResult

class BaseJokeRepository(
    private val cloudDataSource: CloudDataSource,
    private val mapper: JokeDto.Mapper,
    private val handleError: HandleError
) : JokeRepository {
    override fun getJoke(): LoadResult {
        try {
            val loadResult = cloudDataSource.getJoke().map(mapper)
            return loadResult
        } catch (e: Exception) {
            throw handleError.handle(e)
        }
    }

}