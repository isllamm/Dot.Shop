package com.iei.dotshop.ui.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iei.dotshop.databinding.FragmentHomeBinding
import com.iei.dotshop.ui.activity.main.MainActivity


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var parent: MainActivity
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        parent = requireActivity() as MainActivity

        setupUI()
        return binding.root
    }

    private fun setupUI() {
        parent.showLogo(true)
        parent.showToolbar(true)
    }

}