package com.iei.dotshop.ui.fragments.orders

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.iei.dotshop.R
import com.iei.dotshop.databinding.FragmentActiveOrdersBinding
import com.iei.dotshop.databinding.FragmentOrdersBinding


class ActiveOrdersFragment : Fragment() {

    private lateinit var binding: FragmentActiveOrdersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_active_orders, container, false)
       // initViews()
        return binding.root  }

}