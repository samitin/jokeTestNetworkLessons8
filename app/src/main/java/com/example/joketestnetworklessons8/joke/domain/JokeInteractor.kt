package com.example.joketestnetworklessons8.joke.domain

import com.example.joketestnetworklessons8.core.error.DomainException
import com.example.joketestnetworklessons8.joke.domain.data.JokeRepository

interface JokeInteractor {
    suspend fun getJoke() : JokeResult

    class Base(
        private val repository: JokeRepository,
        private val successMapper : LoadResultToJokeResult,
        private val errorMapper : DomainExceptionToJokeResult
    ) : JokeInteractor {
        override suspend fun getJoke(): JokeResult {
            try {
                val result = repository.getJoke()
                return result.map(successMapper)
            }catch (e : DomainException.Abstract){
                return e.map(errorMapper)
            }
        }
    }
}