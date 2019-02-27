package com.github.juyou

import android.app.Dialog
import android.content.Context
import android.view.Gravity

class QRCodeDialog @JvmOverloads constructor(ctx: Context, themeId: Int = R.style.QRCodeDialogTheme) :
    Dialog(ctx, themeId) {
    init {
        setContentView(R.layout.dialog_qrcode)

        val attributes = window?.attributes
        attributes?.width = 300.px2dp(context).toInt()
        attributes?.height = 300.px2dp(context).toInt()
        attributes?.gravity = Gravity.CENTER
        window?.attributes = attributes

        setCanceledOnTouchOutside(true)
    }
}
