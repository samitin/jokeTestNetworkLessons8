package com.example.joketestnetworklessons8.core

import com.example.joketestnetworklessons8.app.moduls.JokeModule
import com.example.joketestnetworklessons8.joke.presentation.JokeViewModel
import com.example.joketestnetworklessons8.app.moduls.MainModule
import com.example.joketestnetworklessons8.main.MainViewModel

interface ProvideViewModel {
    fun <T : MyViewModel<*>> viewModel(clasz : Class<T>) : T

    class MakeViewModel(private val core : Core) : ProvideViewModel {

        override fun <T : MyViewModel<*>> viewModel(clasz: Class<T>): T =
            when(clasz){
                MainViewModel::class.java -> MainModule(core).viewModel()
                JokeViewModel::class.java -> JokeModule(core).viewModel()
                else -> IllegalStateException()
            } as T

    }

    class Factory(private val makeViewModel : ProvideViewModel, ) : ProvideViewModel, ClearViewModel{
        private var viewModelMap = mutableMapOf<Class<out MyViewModel<*>>, MyViewModel<*>>()
        override fun clearViewModel(clasz: Class<out MyViewModel<*>>) {
            viewModelMap.remove(clasz)
        }

        override fun <T : MyViewModel<*>> viewModel(clasz: Class<T>): T =
            if (viewModelMap.containsKey(clasz)){
                viewModelMap[clasz]
            }else{
                val viewModel = makeViewModel.viewModel(clasz)
                viewModelMap[clasz] = viewModel
                viewModel
            } as T


    }
}