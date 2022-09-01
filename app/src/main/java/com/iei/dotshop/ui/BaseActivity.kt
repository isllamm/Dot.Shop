package com.iei.dotshop.ui.activity

import android.content.res.Resources
import android.os.Bundle
import android.view.View
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.ObservableBoolean
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.iei.dotshop.utils.extension.bindView


abstract class BaseActivity<B : ViewDataBinding>  : AppCompatActivity() {

    lateinit var binding: B

    val baseShowProgress = ObservableBoolean()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindView()

          }

    fun setOpacityBackground(view: View, @ColorRes color: Int) {
        view.setBackgroundColor(
            try {
                ContextCompat.getColor(this, color)
            } catch (e: Resources.NotFoundException) {
                0
            }
        )
    }

}
