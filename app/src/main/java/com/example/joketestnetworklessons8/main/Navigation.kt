package com.example.joketestnetworklessons8.main


import com.example.joketestnetworklessons8.core.*

interface Navigation {
    interface Update : UiUpdate<Screen>
    interface Observe : UpdateObserver<Screen>

    interface Mutable : Update, Observe{
        fun clear()
    }

    class Base : UiObservable.Base<Screen>(Screen.Empty), Mutable
}