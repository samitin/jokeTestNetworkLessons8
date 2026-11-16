package com.example.joketestnetworklessons8.joke.presentation

import com.example.joketestnetworklessons8.joke.domain.JokeResult

interface JokeResultToUiStateMapper : JokeResult.Mapper {
    class Base(private val observable: JokeObservable) : JokeResultToUiStateMapper {
        override fun mapSuccess(jokeText: String) {
            observable.update(JokeUiState.Success(jokeText))
        }

        override fun mapError(errorText: String) {
            observable.update(JokeUiState.Error(errorText))
        }
    }
}