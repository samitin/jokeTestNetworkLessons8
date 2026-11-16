package com.example.joketestnetworklessons8.app

import android.app.Application
import com.example.joketestnetworklessons8.core.ClearViewModel
import com.example.joketestnetworklessons8.core.Core
import com.example.joketestnetworklessons8.core.MyViewModel
import com.example.joketestnetworklessons8.core.ProvideViewModel

class JokeApp : Application() , ProvideViewModel, ClearViewModel {

    private lateinit var factory : ProvideViewModel.Factory

    override fun onCreate() {
        super.onCreate()
        factory = ProvideViewModel.Factory(ProvideViewModel.MakeViewModel(BaseCore(this)))
    }
    override fun <T : MyViewModel<*>> viewModel(clasz: Class<T>): T =
        factory.viewModel(clasz)


    override fun clearViewModel(clasz: Class<out MyViewModel<*>>) {
        factory.clearViewModel(clasz)
    }
}