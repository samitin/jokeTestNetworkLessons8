package com.example.joketestnetworklessons8.joke.data.cloud

import com.example.joketestnetworklessons8.joke.domain.data.LoadResult
import com.google.gson.annotations.SerializedName

data class JokeDto (
    @SerializedName("error")
    private val error    : Boolean = true ,
    @SerializedName("category")
    private val category : String ="" ,
    @SerializedName("type")
    private val type     : String =""  ,
    @SerializedName("joke")
    private val joke : String =""  ,
    @SerializedName("delivery")
    private val delivery : String ="" ,
    @SerializedName("id")
    private val id       : Int = 0,
    @SerializedName("safe")
    private val safe     : Boolean = false,
    @SerializedName("lang")
    private val lang     : String =""
){
    interface Mapper{
        fun map(category : String,jokeText : String) : LoadResult
    }
    fun map(mapper: Mapper) : LoadResult = mapper.map(category ,joke)
}
