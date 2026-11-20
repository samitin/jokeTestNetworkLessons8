package com.example.joketestnetworklessons8.core

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

interface RunAsync {

    fun <T : Any> runAsync(coroutineScope: CoroutineScope,background : suspend ()->T,ui : (T) -> Unit)

    class Base(private val dispatchers : DispatcherList) : RunAsync {
        override fun <T : Any> runAsync(
            coroutineScope: CoroutineScope,
            background: suspend () -> T,
            ui: (T) -> Unit
        ) {
            coroutineScope.launch(dispatchers.io()) {
                val result = background.invoke()
                withContext(dispatchers.ui()){
                    ui.invoke(result)
                }
            }
        }
    }
}