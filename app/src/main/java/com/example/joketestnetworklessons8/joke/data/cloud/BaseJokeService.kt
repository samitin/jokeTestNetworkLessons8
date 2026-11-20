package com.example.joketestnetworklessons8.joke.data.cloud

import java.io.BufferedInputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.UnknownHostException

class BaseJokeService : JokeService {
    override fun getJoke(callback: ServiceCallback) {
            var connection: HttpURLConnection? = null
            try {
                val url = URL(JOKE_URL)
                connection = url.openConnection() as HttpURLConnection
                InputStreamReader(BufferedInputStream(connection.inputStream)).use {
                    val lines = it.readLines()
                    val category = lines[2].split(":")[1]
                    val joke: String = lines[4].split(":")[1]
                    callback.returnSuccess(category,joke)
                }
            }finally {
                connection?.disconnect()
            }
    }

    private companion object{
        const val JOKE_URL = "https://v2.jokeapi.dev/joke/Any?type=single&safe_mode"
    }
}