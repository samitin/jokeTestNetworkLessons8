package com.example.joketestnetworklessons8.main

import com.example.joketestnetworklessons8.core.MyViewModel
import com.example.joketestnetworklessons8.core.UiObserver
import com.example.joketestnetworklessons8.joke.ui.JokeScreen

interface MainViewModel : MyViewModel<Screen> {
    fun showJoke(firstRun : Boolean)
    fun observed()

    class Base (private val navigation: Navigation.Mutable) : MainViewModel {
        override fun observed() = navigation.clear()

        override fun showJoke(firstRun : Boolean) {
            if (firstRun)
                navigation.update(JokeScreen())
        }
        override fun startGettingUpdates(observer: UiObserver<Screen>) {
            navigation.updateObserver(observer)
        }

        override fun stopGettingUpdates() {
            navigation.updateObserver()
        }
    }
}