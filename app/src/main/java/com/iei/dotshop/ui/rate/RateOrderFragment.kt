package com.iei.dotshop.ui.rate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iei.dotshop.R
import com.iei.dotshop.databinding.FragmentRateOrderBinding
import com.iei.dotshop.databinding.FragmentSuccessfulRateBinding
import com.iei.dotshop.ui.activity.main.MainActivity


class RateOrderFragment : Fragment() {
    private lateinit var binding: FragmentRateOrderBinding
    private lateinit var parent: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRateOrderBinding.inflate(inflater)
        parent = requireActivity() as MainActivity

        setupUI()
        onClick()
        return binding.root
    }

    private fun onClick() {
        binding.submitBtn.setOnClickListener {
            parent.navController.navigate(R.id.action_rateOrderFragment_to_successfulRateFragment)
        }

    }

    private fun setupUI() {
        parent.showToolbar(false)
        parent.showBottomNav(false)
    }

}