package com.esoapps.applixirexample.applixirAds

import android.view.ViewGroup

interface AdClosedUiListener {
    fun statusCallBack(
        webViewContainerRv: ViewGroup?,
        webViewApplixirKotlin: WebViewApplixirKotlin?,
        status: String?,
    )
}