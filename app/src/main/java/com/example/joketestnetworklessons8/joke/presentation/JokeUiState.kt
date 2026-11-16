package com.example.joketestnetworklessons8.joke.presentation

import com.example.joketestnetworklessons8.core.view.HideAndShow
import com.example.joketestnetworklessons8.core.view.ShowText
import java.io.Serializable

interface JokeUiState : Serializable {

    fun observed(representative : Observed) = representative.observed()
    fun restoreAfterDeath(observable : JokeObservable) = observable.update(this)
    fun show(jokeTextView: ShowText, errorTextView: ShowText, loading: HideAndShow, button: HideAndShow)

    object Initialize : JokeUiState {
        override fun show(jokeTextView: ShowText, errorTextView: ShowText, loading: HideAndShow, button: HideAndShow) {
            jokeTextView.hide()
            errorTextView.hide()
            loading.hide()
            button.show()
        }
    }

    object Loading : JokeUiState {
        override fun show(jokeTextView: ShowText, errorTextView: ShowText, loading: HideAndShow, button: HideAndShow) {
            jokeTextView.hide()
            errorTextView.hide()
            loading.show()
            button.hide()
        }
    }

    class Success(private val textJoke: String) : JokeUiState {
        override fun show(jokeTextView: ShowText, errorTextView: ShowText, loading: HideAndShow, button: HideAndShow) {
            jokeTextView.show()
            jokeTextView.showText(textJoke)
            errorTextView.hide()
            loading.hide()
            button.show()
        }
    }

    class Error(private val textError: String) : JokeUiState {
        override fun show(jokeTextView: ShowText, errorTextView: ShowText, loading: HideAndShow, button: HideAndShow) {
            jokeTextView.hide()
            errorTextView.show()
            errorTextView.showText(textError)
            loading.hide()
            button.hide()
        }

    }
    object Empty : JokeUiState {
        override fun observed(representative: Observed) = Unit
        override fun restoreAfterDeath(observable: JokeObservable) = Unit
        override fun show(jokeTextView: ShowText, errorTextView: ShowText, loading: HideAndShow, button: HideAndShow) = Unit
    }
}