package com.example.joketestnetworklessons8.joke.presentation

import com.example.joketestnetworklessons8.core.SaveAndRestoreState

interface SaveAndRestoreJokeUiState {

    interface Save : SaveAndRestoreState.Save<JokeUiState>

    interface Restore : SaveAndRestoreState.Restore<JokeUiState>

    interface Mutable : Save, Restore


}