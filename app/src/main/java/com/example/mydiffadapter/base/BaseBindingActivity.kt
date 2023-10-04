package com.example.mydiffadapter.base

import android.content.Context
import android.content.ContextWrapper
import android.os.Bundle
import android.util.Log
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.mydiffadapter.utils.extension.setUpLanguage

abstract class BaseBindingActivity<ViewBinding : ViewDataBinding> :
    AppCompatActivity() {
    private var _binding: ViewBinding? = null
    val viewBinding: ViewBinding get() = _binding!!

    @get:LayoutRes
    abstract val layoutRes: Int
    abstract fun initView(savedInstanceState: Bundle?)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, layoutRes)
        viewBinding.lifecycleOwner = this
        initView(savedInstanceState)
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(ContextWrapper(newBase?.setUpLanguage()))
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}