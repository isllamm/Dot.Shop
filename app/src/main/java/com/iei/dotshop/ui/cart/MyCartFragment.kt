package com.iei.dotshop.ui.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iei.dotshop.R
import com.iei.dotshop.databinding.FragmentMyCartBinding
import com.iei.dotshop.databinding.FragmentProfileBinding
import com.iei.dotshop.ui.main.MainActivity


class MyCartFragment : Fragment() {

    private lateinit var binding: FragmentMyCartBinding
    private lateinit var parent: MainActivity


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyCartBinding.inflate(inflater)
        parent = requireActivity() as MainActivity

        setupUI()
        onClick()
        return binding.root
    }

    private fun onClick() {
        binding.btnContinue1.setOnClickListener{
            parent.navController.navigate(R.id.action_myCartFragment_to_cartFragment)
        }
    }

    private fun setupUI() {
        parent.showToolbar(false)
        parent.showBottomNav(false)
    }

}