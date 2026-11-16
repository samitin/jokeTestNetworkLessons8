package com.example.joketestnetworklessons8.core_ui

import android.os.Build
import android.os.Bundle
import com.example.joketestnetworklessons8.core.IsEmpty
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
        private val bundle : Bundle?,
        private val key : String,
        private val clasz : Class<T>
    ) : Mutable<T>{
        override fun isEmpty(): Boolean =
            bundle == null

        override fun save(data: T) = bundle!!.putSerializable(key,data)

        override fun restore(): T =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
                bundle!!.getSerializable(key,clasz)!!
            else
                bundle!!.getSerializable(key) as T

    }
}