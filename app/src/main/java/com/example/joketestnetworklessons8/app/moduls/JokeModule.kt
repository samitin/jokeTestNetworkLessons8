package com.example.joketestnetworklessons8.app.moduls

import com.example.joketestnetworklessons8.app.BaseProvideResource
import com.example.joketestnetworklessons8.core.Core
import com.example.joketestnetworklessons8.core.DispatcherList
import com.example.joketestnetworklessons8.core.HandleDeath
import com.example.joketestnetworklessons8.core.Module
import com.example.joketestnetworklessons8.core.RunAsync
import com.example.joketestnetworklessons8.core.error.HandleError
import com.example.joketestnetworklessons8.joke.data.BaseJokeRepository
import com.example.joketestnetworklessons8.joke.data.JokeDtoToLoadResultMapper
import com.example.joketestnetworklessons8.joke.data.cloud.BaseCloudDataSource
import com.example.joketestnetworklessons8.joke.data.cloud.JokeService
import com.example.joketestnetworklessons8.joke.domain.DomainExceptionToJokeResult
import com.example.joketestnetworklessons8.joke.domain.JokeInteractor
import com.example.joketestnetworklessons8.joke.domain.LoadResultToJokeResult
import com.example.joketestnetworklessons8.joke.presentation.JokeObservable
import com.example.joketestnetworklessons8.joke.presentation.JokeResultToUiStateMapper
import com.example.joketestnetworklessons8.joke.presentation.JokeViewModel
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JokeModule(
    private val core: Core,
) : Module<JokeViewModel>{
    override fun viewModel(): JokeViewModel {


        val observable : JokeObservable = JokeObservable.Base()
        return JokeViewModel.Base(
            HandleDeath.Base(),
            observable,

            JokeInteractor.Base(
                BaseJokeRepository(
                    BaseCloudDataSource(
                        JokeDtoToLoadResultMapper(),
                                 HandleError.Base()
                       ),
                    ),
                LoadResultToJokeResult.Base(),
                DomainExceptionToJokeResult.Base(
                    BaseProvideResource(core.resourceManager())
                )
            ),

                JokeResultToUiStateMapper.Base(observable),
            RunAsync.Base(DispatcherList.Base())
            )


    }
}