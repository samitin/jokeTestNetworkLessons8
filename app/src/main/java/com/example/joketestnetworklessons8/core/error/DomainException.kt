package com.example.joketestnetworklessons8.core.error

interface DomainException {

    interface Mapper<T : Any>{
        fun mapNoInternetConnection() : T
        fun mapServiceUnavailable() : T
    }
    fun <T : Any> map(mapper: Mapper<T>) : T

    abstract class Abstract : Exception(), DomainException

    object NoInternetConnectionException : Abstract() {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapNoInternetConnection()
        }
    }
    object ServiceUnavailableException : Abstract() {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapServiceUnavailable()
        }
    }
}