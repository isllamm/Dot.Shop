package com.iei.dotshop.ui.fragments.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.iei.dotshop.BuildConfig
import com.iei.dotshop.data.BaseFragment
import com.iei.dotshop.databinding.FragmentLoginBinding
import com.iei.dotshop.ui.activity.auth.ResetPasswordActivity
import com.iei.dotshop.ui.activity.auth.LoginActivity
import com.iei.dotshop.ui.activity.main.MainActivity
import com.iei.dotshop.utils.Extension.isEmailValid
import com.iei.dotshop.utils.ToastUtils.Companion.showToast
import com.iei.dotshop.utils.extension.hideKeyboard
import com.iei.dotshop.utils.extension.showActivity
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    private lateinit var parent: LoginActivity


    private fun onClick() {
        binding.tvForgotPassword.setOnClickListener {
            val intent = Intent(parent.baseContext, ResetPasswordActivity::class.java)
            startActivity(intent)
        }

    }

    private fun handleViewState(action: LoginAction) {
        when (action) {
            is LoginAction.ShowLoading -> {
                if (action.show) {
                    hideKeyboard()
                }
                showProgress(action.show)
            }/*  LoginAction.GoogleClicked -> {
                binding.btnGoogle.isEnabled = false
             //   socialMediaAuthHelper?.beginGoogleLogin(handleGoogleLogin())
            }
            LoginAction.FacebookClicked -> {
                //binding.btnFaceBook.isEnabled = false
                socialMediaAuthHelper?.beginFacebookLogin(
                    handleFacebookLogin(),
                    binding.facebookLoginButtonSdk
                )
            }

            LoginAction.OnForgotClicked -> //navigateSafe(LoginFragmentDirections.actionLoginFragmentToForgoPassFragment())
            LoginAction.OnRegisterClicked -> //navigateSafe(LoginFragmentDirections.actionLoginFragmentToTypeFragment())
          */  LoginAction.LoginSuccess -> {
                showActivity(MainActivity::class.java, clearAllStack = true)
            }

            is LoginAction.ShowFailureMsg -> action.message?.let { activity?.let { it1 ->
                showToast(
                    it1, it)
            } }
         //   LoginAction.ContinueUserData ->// navigateSafe(LoginFragmentDirections.actionLoginFragmentToTypeFragment())

      else -> {

      }}
    }

    override fun onFragmentReady() {
        onClick()
    }
}