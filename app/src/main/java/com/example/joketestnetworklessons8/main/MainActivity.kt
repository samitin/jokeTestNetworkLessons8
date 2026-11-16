package com.example.joketestnetworklessons8.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.joketestnetworklessons8.core.ClearViewModel
import com.example.joketestnetworklessons8.core.MyViewModel
import com.example.joketestnetworklessons8.core.ProvideViewModel
import com.example.joketestnetworklessons8.core.UiObserver
import com.example.joketestnetworklessons8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , ProvideViewModel, ClearViewModel{

    private lateinit var viewModel: MainViewModel
    private lateinit var observer : ActivityCallback

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = (application as ProvideViewModel).viewModel(MainViewModel::class.java)
        viewModel.showJoke(savedInstanceState == null)
        observer = object : ActivityCallback {
            override fun update(data: Screen) {
                data.show(binding.container.id,supportFragmentManager)
                data.observed(viewModel)
            }
        }
    }


    override fun <T : MyViewModel<*>> viewModel(clasz: Class<T>): T {
        return (application as ProvideViewModel).viewModel(clasz)
    }

    override fun clearViewModel(clasz: Class<out MyViewModel<*>>) {
        (application as ClearViewModel).clearViewModel(clasz)
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
interface ActivityCallback : UiObserver<Screen>