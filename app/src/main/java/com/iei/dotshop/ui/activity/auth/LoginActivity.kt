package com.iei.dotshop.ui.activity.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.iei.dotshop.R
import com.iei.dotshop.databinding.ActivityLoginBinding
import com.iei.dotshop.utils.LoadingUtil
import dagger.hilt.android.AndroidEntryPoint


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var loadingUtil: LoadingUtil
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadingUtil = LoadingUtil(this)
        setupNavController()

        onClick()

    }

    private fun setupNavController() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.login_nav_host_fragment)
                as NavHostFragment
        navController = navHostFragment.navController
    }

    private fun onClick() {
        binding.llSignIn.setOnClickListener {

            binding.tvReg.setTextColor(getColor(R.color.gray_800))
            binding.tvReg.textSize = 14F
            binding.view2.background = getDrawable(R.color.transparent)

            binding.tvLogin.textSize = 24F
            binding.tvLogin.setTextColor(getColor(R.color.black))
            binding.view1.background = getDrawable(R.color.green)
            navController.navigate(R.id.loginFragment)
        }

        binding.llReg.setOnClickListener {
            binding.tvReg.setTextColor(getColor(R.color.black))
            binding.tvReg.textSize = 24F
            binding.view2.background = getDrawable(R.color.green)

            binding.tvLogin.textSize = 14F
            binding.tvLogin.setTextColor(getColor(R.color.gray_800))
            binding.view1.background = getDrawable(R.color.transparent)
            navController.navigate(R.id.registerFragment)
        }
    }
}