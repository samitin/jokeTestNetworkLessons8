package com.example.joketestnetworklessons8.joke.data.cloud

import com.google.gson.Gson
import java.io.BufferedInputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.UnknownHostException

class BaseJokeService(private val gson: Gson) : JokeService {
    override fun getJoke(callback: ServiceCallback) {
            var connection: HttpURLConnection? = null
            try {
                val url = URL(JOKE_URL)
                connection = url.openConnection() as HttpURLConnection
                InputStreamReader(BufferedInputStream(connection.inputStream)).use {
                    val line = it.readText()
                    val dto = gson.fromJson(line, JokeDto::class.java)
                    callback.returnSuccess(dto)
                }
            }finally {
                connection?.disconnect()
            }
    }

    private companion object{
        const val JOKE_URL = "https://v2.jokeapi.dev/joke/Any?type=single&safe_mode"
    }
}