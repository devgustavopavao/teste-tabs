package com.example.teste_tabs.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.teste_tabs.R
import com.example.teste_tabs.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {
    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View  {
        _binding = FragmentSplashBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         Handler(Looper.getMainLooper()).postDelayed(this::initApp,3000)
    }

    private fun initApp() {
        findNavController().navigate(R.id.action_splashFragment_to_mainFragment2)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}