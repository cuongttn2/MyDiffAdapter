package com.example.mydiffadapter.ui.main.activity

import android.os.Bundle
import com.example.mydiffadapter.MainApplication
import com.example.mydiffadapter.R
import com.example.mydiffadapter.base.BaseBindingActivity
import com.example.mydiffadapter.databinding.ActivityMain2Binding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity2 : BaseBindingActivity<ActivityMain2Binding>() {

    override val layoutRes: Int = R.layout.activity_main2

    override fun initView(savedInstanceState: Bundle?) {
        viewBinding.btnBack2.setOnClickListener {
            MainApplication.instance.dataManager.saveNationCode("vi")
            finish()
        }
    }

}