package com.example.teste_tabs.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.teste_tabs.R
import com.example.teste_tabs.adapter.ViewPagerAdapter
import com.example.teste_tabs.databinding.FragmentMainBinding
import com.example.teste_tabs.databinding.FragmentSplashBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View  {
        _binding = FragmentMainBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTab()
    }

    private fun initTab() {
        val viewpagerAdapter = ViewPagerAdapter(requireActivity())

        viewpagerAdapter.addFragment(LoginFragment(),R.string.tab_login)
        viewpagerAdapter.addFragment(CriarContaFragment(),R.string.tab_create)
        with(binding.viewpager){
            adapter = viewpagerAdapter
            offscreenPageLimit = viewpagerAdapter.itemCount
        }

        TabLayoutMediator(binding.tablayout,binding.viewpager){ tab,position ->
            tab.text = getText(viewpagerAdapter.getTitle(position))
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}