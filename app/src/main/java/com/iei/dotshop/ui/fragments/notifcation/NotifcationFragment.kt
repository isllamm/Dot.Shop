package com.iei.dotshop.ui.fragments.notifcation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iei.dotshop.R
import com.iei.dotshop.ui.activity.main.MainActivity

class NotifcationFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notifcation, container, false)
    }

    private fun setupUI() {
    MainActivity().setToolbarTitle(getString(R.string.notifcation))

    }

}