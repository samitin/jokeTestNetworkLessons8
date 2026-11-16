package com.example.joketestnetworklessons8.core

interface ProvideResource {
    fun noConnectionMassage() : String
    fun serviceUnavailableMassage() : String
}