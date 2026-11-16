package com.example.joketestnetworklessons8.app

import android.content.Context
import com.example.joketestnetworklessons8.core.Core
import com.example.joketestnetworklessons8.core.ResourceManager
import com.example.joketestnetworklessons8.main.Navigation

class BaseCore(context: Context) : Core{
    private val navigation = Navigation.Base()
    private val resourceManager: ResourceManager = BaseResourceManager(context)

    override fun navigation(): Navigation.Mutable = navigation
    override fun resourceManager(): ResourceManager {
        return resourceManager
    }
}