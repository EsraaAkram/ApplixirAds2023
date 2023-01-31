package com.esoapps.applixir

import android.app.Activity
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.ViewGroup

class SimplerApplixirAds : AdClosedUiListener {

    fun loadApplixirAd(
        webViewContainerRv: ViewGroup?,
        act: Activity,
        url: String
    ): WebViewApplixirKotlin {

        var params = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT,
        )
        var webViewApplixirKotlin = WebViewApplixirKotlin(
            act,
            url
        )

        //OLD:fastLoadApplixirAd
        webViewApplixirKotlin.loadUrl("")

        webViewContainerRv?.addView(webViewApplixirKotlin, params)
        webViewApplixirKotlin.visibility = View.INVISIBLE
        return webViewApplixirKotlin
    }

    private fun fastLoadApplixirAd(
        webViewContainerRv: ViewGroup?,
        webViewApplixirKotlin: WebViewApplixirKotlin?,
        addClosedUiListener: AdClosedUiListener,

        ) {


        webViewApplixirKotlin?.showAds(object : WebViewApplixirKotlin.OnCompleteAdListener {
            override fun statusCallBack(status: String?) {

                if (status == "sys-closing") { //AD CLOSED


                    addClosedUiListener.statusCallBack(
                        webViewContainerRv = webViewContainerRv,
                        webViewApplixirKotlin = webViewApplixirKotlin,

                        status = status,

                        )
                }
            }
        })


    }

    fun showApplixirAd(
        webViewContainerRv: ViewGroup?,
        webViewApplixirKotlin: WebViewApplixirKotlin?,
    ) {

        fastLoadApplixirAd(
            webViewContainerRv = webViewContainerRv,
            webViewApplixirKotlin = webViewApplixirKotlin,
            addClosedUiListener = this,
        )

        hideAndShowWebView(webViewContainerRv)
    }


    override fun statusCallBack(
        webViewContainerRv: ViewGroup?,
        webViewApplixirKotlin: WebViewApplixirKotlin?,
        status: String?,
    ) {

        Handler(Looper.getMainLooper()).post {
            hideAndShowOriginal(webViewContainerRv)
        }
    }

    fun closeAd(
        webViewContainerRv: ViewGroup?,
        webViewApplixirKotlin: WebViewApplixirKotlin?,
    ): Boolean {
        var adIsOpen = false

        if (webViewApplixirKotlin?.visibility == View.VISIBLE) {
            webViewApplixirKotlin.loadUrl("")

            Handler(Looper.getMainLooper()).post {
                hideAndShowOriginal(webViewContainerRv)
            }

            adIsOpen = true
        }

        return adIsOpen
    }
}