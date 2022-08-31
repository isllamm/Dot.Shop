package com.iei.dotshop.ui.offers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iei.dotshop.R
import com.iei.dotshop.databinding.FragmentOffersBinding
import com.iei.dotshop.databinding.FragmentProfileBinding
import com.iei.dotshop.ui.main.MainActivity


class OffersFragment : Fragment() {

    private lateinit var binding : FragmentOffersBinding
    private lateinit var parent: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOffersBinding.inflate(inflater)
        parent = requireActivity() as MainActivity

        setupUI()
        return binding.root
    }

    private fun setupUI() {
        parent.setToolbarTitle(getString(R.string.offers))
        parent.showToolbar(true)
    }


}