package com.example.joketestnetworklessons8.core

import android.os.Build
import android.os.Bundle
import java.io.Serializable

interface SaveAndRestoreState<T : Serializable> {

    interface Save <T : Serializable> {
        fun save(data : T)
    }
    interface Restore<T : Serializable> : IsEmpty {
        fun restore() : T
    }
    interface Mutable <T : Serializable> : Save<T> , Restore<T>

    abstract class Abstract<T : Serializable>(
        protected val key : String,
        protected val clasz : Class<T>
    ) : Mutable<T>
}