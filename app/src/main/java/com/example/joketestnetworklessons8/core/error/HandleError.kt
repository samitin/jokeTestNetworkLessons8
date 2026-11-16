package com.example.joketestnetworklessons8.core.error

import java.net.UnknownHostException

interface HandleError {
    fun handle(error : Exception) : Throwable

    class Base : HandleError {
        override fun handle(error: Exception): Throwable =
            if (error is UnknownHostException)
                DomainException.NoInternetConnectionException
            else
                DomainException.ServiceUnavailableException
    }
}