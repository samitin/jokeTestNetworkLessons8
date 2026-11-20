package com.example.joketestnetworklessons8.core

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

interface DispatcherList {
    fun io() : CoroutineDispatcher
    fun ui() : CoroutineDispatcher
    class Base : DispatcherList {
        override fun io(): CoroutineDispatcher = Dispatchers.IO

        override fun ui(): CoroutineDispatcher = Dispatchers.Main
    }
}