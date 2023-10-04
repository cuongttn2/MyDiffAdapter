package com.example.mydiffadapter.utils

import android.annotation.SuppressLint
import android.content.Context
import com.example.mydiffadapter.MainApplication
import com.example.mydiffadapter.R
import com.example.mydiffadapter.model.NationUI
import kotlin.random.Random

object Utils {

    @SuppressLint("Recycle")
    fun getListNation(context: Context): MutableList<NationUI> {
        val list = mutableListOf<NationUI>()
        val arrFlag = context.resources.obtainTypedArray(R.array.array_flag)
        val arrCode = context.resources.getStringArray(R.array.array_language_code)
        context.resources.getStringArray(R.array.array_nation).mapIndexed { index, s ->
            list.add(
                NationUI(
                    id = index,
                    image = arrFlag.getResourceId(index, 0),
                    name = s,
                    arrCode[index],
                    randomNumber = Random.nextInt(0, 100),
                )
            )
        }
        for (i in 0 until list.size) {
            if (list[i].code == MainApplication.instance.dataManager.getNationCode()) {
                list[i].isCheck = true
                break
            }
        }
        return list
    }

}