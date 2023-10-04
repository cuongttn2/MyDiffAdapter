package com.example.mydiffadapter.utils

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter

@BindingAdapter("app:imageRes")
fun setImageResource(imageView: ImageView, @DrawableRes imageRes: Int) {
    imageView.setImageResource(imageRes)
}