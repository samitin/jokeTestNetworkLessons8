package com.example.joketestnetworklessons8.joke.domain.data

interface LoadResult {
    interface Mapper<T : Any>{
        fun mapSuccess(jokeText : String) : T
    }
    fun <T : Any>map(mapper : Mapper<T>) : T

    class Base(private val jokeText : String) : LoadResult {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapSuccess(jokeText)
        }
    }
}