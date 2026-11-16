package com.example.joketestnetworklessons8.app.moduls

import com.example.joketestnetworklessons8.core.Core
import com.example.joketestnetworklessons8.core.Module
import com.example.joketestnetworklessons8.main.MainViewModel

class MainModule(
    private val core: Core
) : Module<MainViewModel> {
    override fun viewModel(): MainViewModel {
        return MainViewModel.Base(core.navigation())
    }
}