package com.example.joketestnetworklessons8.joke.domain

import com.example.joketestnetworklessons8.core.ProvideResource
import com.example.joketestnetworklessons8.core.error.DomainException

interface DomainExceptionToJokeResult : DomainException.Mapper<JokeResult> {
    class Base(private val provideResource: ProvideResource) : DomainExceptionToJokeResult {
        override fun mapNoInternetConnection(): JokeResult {
            return JokeResult.Error(provideResource.noConnectionMassage())
        }

        override fun mapServiceUnavailable(): JokeResult {
            return JokeResult.Error(provideResource.serviceUnavailableMassage())
        }
    }
}