package com.example.mydiffadapter.ui.main.activity

import android.content.Context
import android.os.Bundle
import android.util.Log
import com.example.mydiffadapter.MainApplication
import com.example.mydiffadapter.R
import com.example.mydiffadapter.base.BaseBindingActivity
import com.example.mydiffadapter.databinding.ActivityMainBinding
import com.example.mydiffadapter.ui.home.HomeFragment
import com.example.mydiffadapter.ui.language.LanguageFragment
import com.example.mydiffadapter.utils.extension.setUpLanguage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseBindingActivity<ActivityMainBinding>() {

    override val layoutRes: Int = R.layout.activity_main

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase?.setUpLanguage())
        Log.d("CHECK_", "attachBaseContext: ")

    }

    override fun initView(savedInstanceState: Bundle?) {
        Log.d("CHECK_", "initView: ")
        if (intent != null) {
            if (intent?.extras?.getString("HOME_FRG") == "GO_TO_LANGUAGE_FRG") {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.contentMain, LanguageFragment())
                    .addToBackStack(null).commit()
            } else {
                supportFragmentManager.beginTransaction().add(R.id.contentMain, HomeFragment())
                    .addToBackStack(null).commit()
            }
        }
    }

    override fun onResume() {
        super.onResume()
//        viewBinding.tvTest.text = this.setUpLanguage().getString(R.string.select_language)
        Log.d("CHECK_", "onResume: ${MainApplication.instance.dataManager.getNationCode()} ")
    }


}