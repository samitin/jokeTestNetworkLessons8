package com.example.joketestnetworklessons8.core

interface Module<T : MyViewModel<*>> {
    fun viewModel() : T
}