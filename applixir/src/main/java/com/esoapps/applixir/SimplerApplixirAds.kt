package com.esoapps.applixir

import android.app.Activity
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.ViewGroup

class SimplerApplixirAds : AdClosedUiListener {
    var showingAdsCounter = 0


    fun loadApplixirAd(
        webviewContainerRv: ViewGroup?,
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

        //webViewApplixirKotlin.loadUrl(url)
        fastLoadApplixirAd(
            webviewContainerRv = webviewContainerRv,
            webViewApplixirKotlin = webViewApplixirKotlin,
            addClosedUiListener = this,

            )
        webviewContainerRv!!.addView(webViewApplixirKotlin, params)
        webViewApplixirKotlin.visibility = View.INVISIBLE
        return webViewApplixirKotlin
    }

    fun fastLoadApplixirAd(
        webviewContainerRv: ViewGroup?,
        webViewApplixirKotlin: WebViewApplixirKotlin?,
        addClosedUiListener: AdClosedUiListener,

        ) {


        //hideAndShowWebView(webviewContainerRv)

        webViewApplixirKotlin?.showAds(object : WebViewApplixirKotlin.OnCompleteAdListener {
            override fun statusCallBack(status: String?) {

                if (status == "sys-closing") { //AD CLOSED


                    addClosedUiListener.statusCallBack(
                        webviewContainerRv = webviewContainerRv,
                        webViewApplixirKotlin = webViewApplixirKotlin,

                        status = status,

                        )
                }
            }
        })


    }

    fun showApplixirAd(
        webviewContainerRv: ViewGroup?,
        webViewApplixirKotlin: WebViewApplixirKotlin?,
    ) {
        showingAdsCounter += 1
        if (showingAdsCounter > 1) {//RE-PRESS SO LOAD ANOTHER AD
            fastLoadApplixirAd(
                webviewContainerRv = webviewContainerRv,
                webViewApplixirKotlin = webViewApplixirKotlin,
                addClosedUiListener = this,
            )
        }

        hideAndShowWebView(webviewContainerRv)
    }


    override fun statusCallBack(
        webviewContainerRv: ViewGroup?,
        webViewApplixirKotlin: WebViewApplixirKotlin?,
        status: String?,
    ) {

        Handler(Looper.getMainLooper()).post {
            hideAndShowOriginal(webviewContainerRv)
        }
    }

    fun closeAd(
        webviewContainerRv: ViewGroup?,
        webViewApplixirKotlin: WebViewApplixirKotlin?,
    ): Boolean {
        var adIsOpen = false

        if (webViewApplixirKotlin?.visibility == View.VISIBLE) {
            webViewApplixirKotlin.loadUrl("")

            Handler(Looper.getMainLooper()).post {
                hideAndShowOriginal(webviewContainerRv)
            }

            adIsOpen = true
        }

        return adIsOpen
    }
}