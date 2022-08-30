package com.iei.dotshop.ui.fragments.payment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iei.dotshop.R
import com.iei.dotshop.databinding.FragmentPaymentsBinding
import com.iei.dotshop.ui.activity.main.MainActivity

class PaymentsFragment : Fragment() {
    private lateinit var binding: FragmentPaymentsBinding
    private lateinit var parent: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPaymentsBinding.inflate(inflater)
        parent = requireActivity() as MainActivity

        onClick()
        setupUI()
        return binding.root
    }
    private fun onClick() {
        binding.backArrow.setOnClickListener{
            parent.navController.navigate(R.id.profileFragment)

        }
    }

    private fun setupUI() {
        parent.showToolbar(false)
    }

}