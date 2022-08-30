package com.iei.dotshop.ui.fragments.wishList


import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.iei.dotshop.R
import com.iei.dotshop.databinding.FragmentWishListBinding


class WishListFragment : Fragment() {

    private lateinit var binding: FragmentWishListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_wish_list, container, false)
        return binding.root

    }


}