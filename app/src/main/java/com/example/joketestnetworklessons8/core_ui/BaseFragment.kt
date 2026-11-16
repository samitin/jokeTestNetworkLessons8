package com.example.joketestnetworklessons8.core_ui


import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.example.joketestnetworklessons8.core.MyViewModel
import com.example.joketestnetworklessons8.core.ProvideViewModel

abstract class BaseFragment<VM : MyViewModel<*>,B : ViewBinding> : Fragment() {
    protected lateinit var viewModel : VM
    protected abstract val clasz : Class<VM>

    private var _binding : B ?= null
    val binding : B get() =  _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = (requireActivity() as ProvideViewModel).viewModel(clasz)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = createBinding(inflater,container)
        return binding.root
    }

    abstract fun createBinding(inflater: LayoutInflater, container: ViewGroup?) : B

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}