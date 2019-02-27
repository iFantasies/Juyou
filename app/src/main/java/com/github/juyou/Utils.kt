package com.github.juyou

import android.content.Context
import android.util.TypedValue

fun Number.px2dp(context: Context) =
    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, toFloat(), context.resources.displayMetrics)

fun Number.dp2px(context: Context) =
    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, toFloat(), context.resources.displayMetrics)
