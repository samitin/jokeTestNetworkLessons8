package com.example.joketestnetworklessons8.joke.ui

import android.os.Build
import android.os.Bundle
import com.example.joketestnetworklessons8.core.SaveAndRestoreState
import com.example.joketestnetworklessons8.joke.presentation.JokeUiState
import com.example.joketestnetworklessons8.joke.presentation.SaveAndRestoreJokeUiState


class BaseSaveAndRestoreJokeUiState(private val bundle : Bundle?)
    : SaveAndRestoreState.Abstract<JokeUiState>(
    KEY,
    JokeUiState::class.java
),SaveAndRestoreJokeUiState.Mutable{

    override fun isEmpty(): Boolean = bundle == null

    override fun save(data: JokeUiState) = bundle!!.putSerializable(key,data)

    override fun restore(): JokeUiState =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            bundle!!.getSerializable(key,clasz)!!
        else
            bundle!!.getSerializable(key) as JokeUiState


    companion object{
        private const val KEY = "JokeUiStateKey"
    }
}