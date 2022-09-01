package com.iei.dotshop.data

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.iei.dotshop.ui.activity.BaseActivity
import com.iei.dotshop.ui.activity.auth.LoginActivity
import com.iei.dotshop.ui.activity.main.MainActivity
import com.iei.dotshop.utils.extension.bindView
import com.iei.dotshop.utils.extension.castToActivity
import com.iei.dotshop.utils.extension.showAppToast
import com.iei.dotshop.utils.extension.showErrorDialog

import com.techlife.winwin.core.util.SessionManager


/**
 * Created by MahmoudAyman on 6/17/2020.
 **/

abstract class BaseFragment<B : ViewDataBinding> : Fragment() {

    open fun mPageTitle(): String? = null

    /**
     * first: background res
     * second: height
     * */
    open fun mPageToolbarBackground(): Pair<Int, Int>? = null
    open val mTitleGravity: Int = Gravity.CENTER_VERTICAL
    open val showBottomNavigationView: Boolean = true

    abstract fun onFragmentReady()


    private var _binding: B? = null
    open lateinit var binding: B
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindView()
        binding = _binding!!
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
     //   setToolbarTitle(mPageTitle())
        onFragmentReady()
    }


    fun showProgress(show: Boolean = true) {
        castToActivity<BaseActivity<*>> {
            it?.baseShowProgress?.set(show)
        }
    }

    fun showDialog(message: String?) {
        context?.showErrorDialog(message)
    }

    fun showToast(message: String?) {
        context?.showAppToast(message)
    }

    override fun onDestroyView() {
        showProgress(false)
        _binding = null
        super.onDestroyView()
    }


}
