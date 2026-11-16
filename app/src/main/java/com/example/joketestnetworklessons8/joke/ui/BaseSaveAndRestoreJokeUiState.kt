package com.example.joketestnetworklessons8.joke.ui

import android.os.Bundle
import com.example.joketestnetworklessons8.core_ui.SaveAndRestoreState
import com.example.joketestnetworklessons8.joke.presentation.JokeUiState
import com.example.joketestnetworklessons8.joke.presentation.SaveAndRestoreJokeUiState

class BaseSaveAndRestoreJokeUiState(
    bundle: Bundle?
) : SaveAndRestoreState.Abstract<JokeUiState> (
    bundle,
    KEY,
    JokeUiState::class.java
), SaveAndRestoreJokeUiState.Mutable{

    companion object{
        private const val KEY = "JokeUiStateKey"
    }
}
