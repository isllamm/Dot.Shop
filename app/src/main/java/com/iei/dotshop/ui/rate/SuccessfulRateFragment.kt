package com.iei.dotshop.ui.rate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iei.dotshop.R
import com.iei.dotshop.databinding.FragmentPlacedOrderBinding
import com.iei.dotshop.databinding.FragmentSuccessfulRateBinding
import com.iei.dotshop.ui.activity.main.MainActivity


class SuccessfulRateFragment : Fragment() {
    private lateinit var binding: FragmentSuccessfulRateBinding
    private lateinit var parent: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSuccessfulRateBinding.inflate(inflater)
        parent = requireActivity() as MainActivity

        setupUI()
        onClick()
        return binding.root
    }

    private fun onClick() {
        binding.btnGoHome.setOnClickListener {
            parent.navController.navigate(R.id.action_successfulRateFragment_to_homeFragment)
        }

    }

    private fun setupUI() {
        parent.showToolbar(false)
        parent.showBottomNav(false)
    }
}