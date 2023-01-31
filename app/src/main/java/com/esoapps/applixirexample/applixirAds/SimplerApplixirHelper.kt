package com.esoapps.applixirexample.applixirAds


import android.view.View
import android.view.ViewGroup

fun hideAndShowWebView(webViewContainerRv: ViewGroup?) {
    for (i in 0 until webViewContainerRv?.childCount!!) {
        val child: View = webViewContainerRv.getChildAt(i)
        if (child is WebViewApplixirKotlin) {

            webViewContainerRv.getChildAt(i).visibility = View.VISIBLE

        } else {
            webViewContainerRv.getChildAt(i).visibility = View.INVISIBLE
        }
    }

}

fun hideAndShowOriginal(webviewContainerRv: ViewGroup?) {

    for (i in 0 until webviewContainerRv?.childCount!!) {
        val child: View = webviewContainerRv.getChildAt(i)
        if (child is WebViewApplixirKotlin) {

            webviewContainerRv.getChildAt(i).visibility = View.INVISIBLE
        } else {
            webviewContainerRv.getChildAt(i).visibility = View.VISIBLE
        }
    }

}