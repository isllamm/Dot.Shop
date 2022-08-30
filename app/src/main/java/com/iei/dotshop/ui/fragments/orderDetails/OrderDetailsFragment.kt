package com.iei.dotshop.ui.fragments.orderDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.iei.dotshop.R
import com.iei.dotshop.databinding.FragmentOrderDetailsBinding

class OrderDetailsFragment : Fragment() {
    private lateinit var binding: FragmentOrderDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_order_details, container, false)
        initViews()
        return binding.root
    }

    private fun initViews() {

        binding.itemOrderAddress.tvTitle.text = "Address"
        binding.itemPhoneNum.tvTitle.text = "Phone Number"
        binding.itemOrderTotal.tvTitle.text = "Total"
        binding.itemOrderAddress.tvValue.text = "45 Soliman El-Halabi St., Down Town"
        binding.itemPhoneNum.tvValue.text = "2312313123"
        binding.itemOrderTotal.tvValue.text = "1102 $"
    }

}