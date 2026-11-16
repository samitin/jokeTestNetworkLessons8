package com.example.joketestnetworklessons8.app

import com.example.joketestnetworklessons8.R
import com.example.joketestnetworklessons8.core.ProvideResource
import com.example.joketestnetworklessons8.core.ResourceManager

class BaseProvideResource(private val manager: ResourceManager) : ProvideResource {
    override fun noConnectionMassage(): String =
        manager.getString(R.string.no_internet)


    override fun serviceUnavailableMassage(): String =
        manager.getString(R.string.service_unavaible)
}