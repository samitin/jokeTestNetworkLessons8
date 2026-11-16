package com.example.joketestnetworklessons8.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

interface Screen {
    fun observed(viewModel: MainViewModel) = viewModel.observed()

    fun show(containerId : Int, fragmentManager: FragmentManager)

    abstract class Replace(private val clasz : Class<out Fragment>) : Screen{
        override fun show(containerId: Int, fragmentManager: FragmentManager) {
            fragmentManager.beginTransaction()
                .replace(containerId,clasz.getDeclaredConstructor().newInstance())
                .commit()
        }
    }
    abstract class Add(private val clasz : Class<out Fragment>) : Screen{
        override fun show(containerId: Int, fragmentManager: FragmentManager) {
            fragmentManager.beginTransaction()
                .replace(containerId,clasz.getDeclaredConstructor().newInstance())
                .addToBackStack(clasz.simpleName)
                .commit()
        }
    }
    object Empty : Screen {
        override fun show(
            containerId: Int,
            fragmentManager: FragmentManager
        ) = Unit
    }
}