package com.iei.dotshop.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iei.dotshop.R
import com.iei.dotshop.databinding.FragmentProfileBinding
import com.iei.dotshop.ui.main.MainActivity


class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var parent: MainActivity


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater)
        parent = requireActivity() as MainActivity

        setupUI()
        onClick()
        return binding.root


    }

    private fun setupUI() {
        parent.setToolbarTitle(getString(R.string.profile))
        parent.showToolbar(true)
    }

    private fun onClick() {
        binding.tvPersonal.setOnClickListener {
            parent.navController.navigate(R.id.action_profileFragment_to_personalInfoFragment)
        }
        binding.tvAddress.setOnClickListener {
            parent.navController.navigate(R.id.action_profileFragment_to_addressesFragment)
        }
        binding.tvPayments.setOnClickListener {
            parent.navController.navigate(R.id.action_profileFragment_to_paymentsFragment)
        }
        binding.tvVouchers.setOnClickListener {
            parent.navController.navigate(R.id.action_profileFragment_to_vouchersFragment)
        }
    }


}