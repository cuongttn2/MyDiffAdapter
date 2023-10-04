package com.example.mydiffadapter.model

import androidx.annotation.DrawableRes

data class NationUI(
    var id: Int? = -1,
    @DrawableRes var image: Int,
    var name: String,
    var code: String,
    var randomNumber: Int? = 0,
    var isCheck: Boolean = false,
) {}
