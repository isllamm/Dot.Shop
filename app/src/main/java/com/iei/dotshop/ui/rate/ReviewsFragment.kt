package com.iei.dotshop.ui.rate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iei.dotshop.R
import com.iei.dotshop.databinding.FragmentRateOrderBinding
import com.iei.dotshop.databinding.FragmentReviewsBinding
import com.iei.dotshop.ui.activity.main.MainActivity


class ReviewsFragment : Fragment() {

    private lateinit var binding: FragmentReviewsBinding
    private lateinit var parent: MainActivity


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentReviewsBinding.inflate(inflater)
        parent = requireActivity() as MainActivity

        setupUI()
        onClick()
        return binding.root
    }

    private fun onClick() {
        binding.btnContinue1.setOnClickListener {
            parent.navController.navigate(R.id.action_reviewsFragment_to_rateOrderFragment)
        }
    }

    private fun setupUI() {
        parent.showToolbar(false)
        parent.showBottomNav(false)
    }


}