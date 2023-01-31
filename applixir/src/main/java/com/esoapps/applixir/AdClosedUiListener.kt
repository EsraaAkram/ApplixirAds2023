package com.esoapps.applixir


import android.view.ViewGroup

interface AdClosedUiListener {
    fun statusCallBack(
        webViewContainerRv: ViewGroup?,
        webViewApplixirKotlin: WebViewApplixirKotlin?,
        status: String?,
    )
}