package com.example.joketestnetworklessons8.joke.presentation

import com.example.joketestnetworklessons8.core.UiObservable
import com.example.joketestnetworklessons8.core.UiObserver

interface JokeObservable : UiObservable<JokeUiState> , SaveJokeUiState{
    class Base : UiObservable.Base<JokeUiState>(JokeUiState.Empty), JokeObservable{
        override fun save(saveAndRestore: SaveAndRestoreJokeUiState.Save) {
            saveAndRestore.save(cache)
        }
    }
}

interface JokeObserver : UiObserver<JokeUiState>{

}