package com.iei.dotshop.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.iei.dotshop.R
import com.iei.dotshop.databinding.FragmentOrdersBinding


class OrdersFragment : Fragment() {
    private lateinit var mSectionAdapter: SectionsPagerAdapterTabs
    private lateinit var binding: FragmentOrdersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_orders, container, false)
        initViews()
        return binding.root
    }

    private fun initViews() {
        mSectionAdapter = SectionsPagerAdapterTabs(getChildFragmentManager())
        binding.viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabs))
        binding.tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(binding.viewPager))
        binding.viewPager.setAdapter(mSectionAdapter)
    }

}


private class SectionsPagerAdapterTabs(fm: FragmentManager?) :
    FragmentPagerAdapter(fm!!) {
    override fun getItem(position: Int): Fragment {
        return if (position == 0) {
            ActiveOrdersFragment()
        } else {
            PreviousOrdersFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }
}