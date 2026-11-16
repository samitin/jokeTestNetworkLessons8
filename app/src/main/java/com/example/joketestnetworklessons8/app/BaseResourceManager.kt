package com.example.joketestnetworklessons8.app

import android.content.Context
import com.example.joketestnetworklessons8.core.ResourceManager

class BaseResourceManager(private val context: Context) : ResourceManager {
    override fun getString(stringId: Int): String {
        return context.getString(stringId)
    }
}