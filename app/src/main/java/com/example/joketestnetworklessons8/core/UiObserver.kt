package com.example.joketestnetworklessons8.core

interface UiObservable <T : Any> : UiUpdate<T>, UpdateObserver<T> {
    fun clear()

    abstract class Base<T : Any>(private val empty : T) : UiObservable<T>{
        protected var cache : T = empty
        private var observer : UiObserver<T> = UiObserver.Empty<T>()

        override fun clear() {
            cache = empty
        }

        override fun update(data: T) {
            cache = data
            observer.update(data)
        }

        override fun updateObserver(uiObserver: UiObserver<T>) {
            observer = uiObserver
            observer.update(cache)
        }
    }

}

interface UiUpdate<T : Any>{
    fun update(data : T)
}
interface UpdateObserver<T : Any>{
    fun updateObserver(uiObserver: UiObserver<T> = UiObserver.Empty())
}

interface UiObserver<T : Any> : UiUpdate<T>{
    fun isEmpty() = false
    class Empty<T : Any> : UiObserver<T> {
        override fun update(data: T) = Unit
        override fun isEmpty(): Boolean = true
    }

}