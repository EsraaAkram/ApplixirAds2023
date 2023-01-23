package com.esoapps.applixir


import android.view.ViewGroup

interface AdClosedUiListener {
    fun statusCallBack(
        webviewContainerRv: ViewGroup?,
        webViewApplixirKotlin: WebViewApplixirKotlin?,
        status: String?,
    )
}