package com.esoapps.applixirexample.applixirAds


import android.app.Activity
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.ViewGroup


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

    webViewApplixirKotlin.loadUrl(url)
    webViewContainerRv!!.addView(webViewApplixirKotlin, params)
    webViewApplixirKotlin.visibility = View.INVISIBLE



    return webViewApplixirKotlin
}

fun showApplixirAd(
    webviewContainerRv: ViewGroup?,
    webViewApplixirKotlin: WebViewApplixirKotlin?,

    ) {


    hideAndShowWebView(webviewContainerRv)

    webViewApplixirKotlin?.showAds(object : WebViewApplixirKotlin.OnCompleteAdListener {
        override fun statusCallBack(status: String?) {

            if (status == "sys-closing") { //AD CLOSED

                Handler(Looper.getMainLooper()).post {
                    hideAndShowOriginal(webviewContainerRv)
                }
            }

        }
    })


}


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