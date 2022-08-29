package com.iei.dotshop.ui.Login.Fragments.Login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iei.dotshop.databinding.FragmentLoginBinding
import com.iei.dotshop.ui.Login.ResetPasswordActivity
import com.iei.dotshop.ui.Login.LoginActivity
import com.iei.dotshop.ui.main.MainActivity

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var parent: LoginActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLoginBinding.inflate(inflater)
        parent = requireActivity() as LoginActivity

        onClick()

        return binding.root
    }

    private fun onClick() {
        binding.tvForgotPassword.setOnClickListener{
            val intent = Intent(parent.baseContext, ResetPasswordActivity::class.java)
            startActivity(intent)
        }

        binding.signInBtn.setOnClickListener{
            val intent = Intent(parent.baseContext, MainActivity::class.java)
            startActivity(intent)
        }
    }


}