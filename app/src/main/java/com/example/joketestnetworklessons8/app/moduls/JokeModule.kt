package com.example.joketestnetworklessons8.app.moduls

import com.example.joketestnetworklessons8.app.BaseProvideResource
import com.example.joketestnetworklessons8.core.Core
import com.example.joketestnetworklessons8.core.HandleDeath
import com.example.joketestnetworklessons8.core.Module
import com.example.joketestnetworklessons8.core.error.HandleError
import com.example.joketestnetworklessons8.joke.data.BaseJokeRepository
import com.example.joketestnetworklessons8.joke.domain.DomainExceptionToJokeResult
import com.example.joketestnetworklessons8.joke.domain.JokeInteractor
import com.example.joketestnetworklessons8.joke.domain.LoadResultToJokeResult
import com.example.joketestnetworklessons8.joke.presentation.JokeObservable
import com.example.joketestnetworklessons8.joke.presentation.JokeResultToUiStateMapper
import com.example.joketestnetworklessons8.joke.presentation.JokeViewModel

class JokeModule(
    private val core: Core,
) : Module<JokeViewModel>{
    override fun viewModel(): JokeViewModel {
        val observable : JokeObservable = JokeObservable.Base()
        return JokeViewModel.Base(
            HandleDeath.Base(),
            observable,

            JokeInteractor.Base(
                BaseJokeRepository(HandleError.Base()),
                LoadResultToJokeResult.Base(),
                DomainExceptionToJokeResult.Base(
                    BaseProvideResource(core.resourceManager())
                )
            ),

                JokeResultToUiStateMapper.Base(observable)
            )


    }
}