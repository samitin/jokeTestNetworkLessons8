package com.example.joketestnetworklessons8.joke.data

import com.example.joketestnetworklessons8.core.error.HandleError
import com.example.joketestnetworklessons8.joke.domain.data.JokeRepository
import com.example.joketestnetworklessons8.joke.domain.data.LoadResult

class BaseJokeRepository(
    private val handleError: HandleError
) : JokeRepository {
    override fun getJoke(): LoadResult {
        try {
            //throw NullPointerException()
            return LoadResult.Base("Шутка ебать в рот какая смешная!!!")
        } catch (e: Exception) {
            throw handleError.handle(e)
        }
    }

}