package com.example.mydiffadapter.data

import android.content.SharedPreferences
import com.example.mydiffadapter.utils.NATION_CODE
import com.example.mydiffadapter.utils.extension.get
import com.example.mydiffadapter.utils.extension.set
import javax.inject.Inject

class DataManager @Inject constructor(private val preferences: SharedPreferences) {

    fun getNationCode(): String {
        var code: String? = preferences[NATION_CODE]
        if (!code.isNullOrEmpty()) return code
        code = "vi"
        return code!!
    }

    fun saveNationCode(code: String) {
        preferences[NATION_CODE] = code
    }
}