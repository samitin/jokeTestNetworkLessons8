package com.example.joketestnetworklessons8.joke.data.cloud

import com.example.joketestnetworklessons8.joke.domain.data.LoadResult

data class JokeDto (
    private val error    : Boolean = true ,
    private val category : String ="" ,
    private val type     : String =""  ,
    private val setup    : String =""  ,
    private val delivery : String ="" ,
    private val id       : Int = 0,
    private val safe     : Boolean = false,
    private val lang     : String =""
){
    interface Mapper{
        fun map(category : String,jokeText : String) : LoadResult
    }
    fun map(mapper: Mapper) : LoadResult = mapper.map(category ,setup)
}
