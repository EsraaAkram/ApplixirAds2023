package com.esoapps.applixirexample.applixirAds

import android.view.ViewGroup

interface AdClosedUiListener {
    fun statusCallBack(
        webviewContainerRv: ViewGroup?,
        webViewApplixirKotlin: WebViewApplixirKotlin?,
        status: String?,
    )
}