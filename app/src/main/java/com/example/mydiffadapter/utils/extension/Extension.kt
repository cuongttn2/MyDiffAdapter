package com.example.mydiffadapter.utils.extension

import android.content.Context
import com.example.mydiffadapter.MainApplication
import java.util.Locale

fun Context.setUpLanguage(): Context {
    val languageCode = MainApplication.instance.dataManager.getNationCode()
    val config = resources.configuration
    val locale = if (languageCode == "zh-rTW") {
        Locale("zh", "TW")
    } else {
        Locale(languageCode)
    }
    config.setLocale(locale)
    return createConfigurationContext(config)
}