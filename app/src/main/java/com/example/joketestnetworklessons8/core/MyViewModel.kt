package com.example.joketestnetworklessons8.core

interface MyViewModel<T : Any> {
    fun startGettingUpdates(observer: UiObserver<T>)

    fun stopGettingUpdates()
}