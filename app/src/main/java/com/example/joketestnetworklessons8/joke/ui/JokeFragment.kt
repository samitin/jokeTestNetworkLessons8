package com.example.joketestnetworklessons8.joke.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.joketestnetworklessons8.core_ui.BaseFragment
import com.example.joketestnetworklessons8.databinding.FragmentJokeBinding
import com.example.joketestnetworklessons8.joke.presentation.JokeObserver
import com.example.joketestnetworklessons8.joke.presentation.JokeUiState
import com.example.joketestnetworklessons8.joke.presentation.JokeViewModel
import com.example.joketestnetworklessons8.joke.presentation.SaveAndRestoreJokeUiState

class JokeFragment : BaseFragment<JokeViewModel, FragmentJokeBinding>() {

    override val clasz: Class<JokeViewModel> = JokeViewModel::class.java

    private lateinit var observer: JokeObserver

    override fun createBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentJokeBinding {
        return FragmentJokeBinding.inflate(inflater,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observer = object : JokeObserver {
            override fun update(data: JokeUiState) {
                activity?.runOnUiThread{
                    // data.observed(viewModel)
                    data.show(binding.textJoke, binding.textJokeError, binding.progressBarJoke, binding.buttonRandomJoke)
                }
              }
        }
        binding.buttonRandomJoke.setOnClickListener {
            viewModel.nextJoke()
        }
        val restoreState = BaseSaveAndRestoreJokeUiState(savedInstanceState)
       viewModel.init(restoreState)

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        viewModel.save(BaseSaveAndRestoreJokeUiState(outState))
    }

    override fun onResume() {
        super.onResume()
        viewModel.startGettingUpdates(observer)
    }

    override fun onPause() {
        super.onPause()
        viewModel.stopGettingUpdates()
    }

}