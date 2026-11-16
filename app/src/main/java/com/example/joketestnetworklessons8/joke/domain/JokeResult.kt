package com.example.joketestnetworklessons8.joke.domain

interface JokeResult {

    interface Mapper{
        fun mapSuccess(jokeText : String)
        fun mapError(errorText : String)
    }
    fun map(mapper: Mapper)

    class Success(private val jokeText : String) : JokeResult {
        override fun map(mapper: Mapper) {
            mapper.mapSuccess(jokeText)
        }
    }
    class Error(private val errorText : String) : JokeResult {
        override fun map(mapper: Mapper) {
            mapper.mapError(errorText)
        }

    }
}