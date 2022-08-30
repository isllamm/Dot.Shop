package com.iei.dotshop.ui.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iei.dotshop.R
import com.iei.dotshop.databinding.FragmentCartBinding
import com.iei.dotshop.databinding.FragmentMyCartBinding
import com.iei.dotshop.ui.main.MainActivity


class CartFragment : Fragment() {

    private lateinit var binding: FragmentCartBinding
    private lateinit var parent: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCartBinding.inflate(inflater)
        parent = requireActivity() as MainActivity

        setupUI()
        onClick()
        return binding.root
    }

    private fun onClick() {
        binding.btnContinue1.setOnClickListener {
            parent.navController.navigate(R.id.action_cartFragment_to_placedOrderFragment)
        }

    }

    private fun setupUI() {
        parent.showToolbar(false)
        parent.showBottomNav(false)
    }


}