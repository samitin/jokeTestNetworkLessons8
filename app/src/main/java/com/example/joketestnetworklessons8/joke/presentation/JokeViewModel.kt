package com.example.joketestnetworklessons8.joke.presentation

import com.example.joketestnetworklessons8.core.HandleDeath
import com.example.joketestnetworklessons8.core.MyViewModel
import com.example.joketestnetworklessons8.core.UiObserver
import com.example.joketestnetworklessons8.joke.domain.JokeInteractor

interface JokeViewModel : MyViewModel<JokeUiState>, SaveJokeUiState, Observed{
    fun nextJoke()
    fun init(restoreState : SaveAndRestoreJokeUiState.Restore)
    class Base(
        private val handleDeath: HandleDeath,
        private val observable: JokeObservable,
        private val interactor: JokeInteractor,
        private val mapper: JokeResultToUiStateMapper
    ) : JokeViewModel {

        override fun init(restoreState: SaveAndRestoreJokeUiState.Restore) {
            if (restoreState.isEmpty()){
                handleDeath.firstOpening()
                observable.update(JokeUiState.Initialize)
            }else{
                if (handleDeath.didDeathHappen()){
                    handleDeath.deathHandled()
                    val uiState = restoreState.restore()
                    uiState.restoreAfterDeath(observable)
                }
            }
        }

        override fun observed() = observable.clear()

        override fun nextJoke() {
            observable.update(JokeUiState.Loading)
            interactor.getJoke().map(mapper)
        }

        override fun startGettingUpdates(observer: UiObserver<JokeUiState>) {
            observable.updateObserver(observer)
        }

        override fun stopGettingUpdates() {
            observable.updateObserver()
        }

        override fun save(saveAndRestore: SaveAndRestoreJokeUiState.Save) {
            observable.save(saveAndRestore)
        }

    }
}

interface SaveJokeUiState{
    fun save(saveAndRestore : SaveAndRestoreJokeUiState.Save)
}
interface Observed{
    fun observed()
}