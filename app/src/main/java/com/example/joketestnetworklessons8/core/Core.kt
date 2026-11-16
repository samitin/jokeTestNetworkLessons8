package com.example.joketestnetworklessons8.core


import com.example.joketestnetworklessons8.main.Navigation

interface Core : ProvideNavigation, ProvideResourceManager{}
interface ProvideNavigation{
    fun navigation() : Navigation.Mutable
}
interface ProvideResourceManager{
    fun resourceManager() : ResourceManager
}