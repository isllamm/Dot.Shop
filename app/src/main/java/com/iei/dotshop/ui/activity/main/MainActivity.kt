package com.iei.dotshop.ui.activity.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.iei.dotshop.R
import com.iei.dotshop.databinding.ActivityMainBinding
import com.iei.dotshop.utils.LoadingUtil


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    private lateinit var loadingUtil: LoadingUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadingUtil = LoadingUtil(this)
        onClick()

        setupNavController()
    }

    private fun onClick() {
        binding.toolbar.ivCart.setOnClickListener {
            navController.navigate(R.id.myCartFragment)
        }
    }

    private fun setupNavController() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
                as NavHostFragment
        navController = navHostFragment.navController
        binding.navView.setupWithNavController(navController)
    }

    fun showToolbar(isVisible: Boolean) {
        binding.toolbar.root.isVisible = isVisible
    }


    fun showBottomNav(isVisible: Boolean) {
        binding.navView.isVisible = isVisible
    }

    fun showLogo(isVisible: Boolean) {
        showTitle(false)
        binding.toolbar.ivLogo.isVisible = isVisible
    }

    fun showTitle(isVisible: Boolean) {
        binding.toolbar.tvCatName.isVisible = isVisible
    }

    fun setToolbarTitle(title: String) {
        showLogo(false)
        showTitle(true)
        binding.toolbar.tvCatName.text = title
    }

    fun showLoading() {
        loadingUtil.showLoading()
    }

    fun hideLoading() {
        loadingUtil.hideLoading()
    }
}