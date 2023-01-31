package com.esoapps.applixir

import android.content.Context
import android.webkit.JavascriptInterface
import android.webkit.WebView

class WebViewApplixirKotlin(context: Context, private val webUrl: String) :
    WebView(context) {

    fun showAds(onCompleteAdListener: OnCompleteAdListener) {
        this.loadUrl(webUrl)
        addJavascriptInterface(object : Applixir(context) {
            @JavascriptInterface
            override fun adStatusCallback(status: String?) {
                super.adStatusCallback(status)

                onCompleteAdListener.statusCallBack(status)
            }
        }, "Android")
    }

    interface OnCompleteAdListener {
        fun statusCallBack(status: String?)
    }

    open inner class Applixir(var mContext: Context) {
        @JavascriptInterface
        open fun adStatusCallback(status: String?) {
        }
    }

    init {
        val webSettings = this.settings
        webSettings.javaScriptEnabled = true
        //TODO:UN COMMENT THE COUPLE LINES OF CODE IF YOU ARE USING BLOGGER AS A HOST FOR ADS:
//        val newUA = "Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.0.4) Gecko/20100101 Firefox/4.0"
//        webSettings.userAgentString = newUA
//        this.webViewClient = WebViewClient()

    }


}