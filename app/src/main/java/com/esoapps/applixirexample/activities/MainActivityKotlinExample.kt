package com.esoapps.applixirexample.activities

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.esoapps.applixirexample.R
import com.esoapps.applixirexample.applixirAds.WebViewApplixirKotlin
import com.esoapps.applixirexample.applixirAds.loadApplixirAd
import com.esoapps.applixirexample.applixirAds.showApplixirAd


class MainActivityKotlinExample : AppCompatActivity() {

    private var rewardBtn: Button? = null
    private var webviewContainerRv: RelativeLayout? = null
    private var webViewApplixirKotlin: WebViewApplixirKotlin? = null
    private val url = "https://js.appcdn.net/Android-test-1.html"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_act)


        itemsDefinitions()

        webViewApplixirKotlin = loadApplixirAd(webviewContainerRv, this, url)


        rewardBtn!!.setOnClickListener {

            showApplixirAd(webviewContainerRv, webViewApplixirKotlin)

        }


    }


    private fun itemsDefinitions() {

        rewardBtn = findViewById(R.id.rewardBtn)
        webviewContainerRv = findViewById(R.id.webviewContainerRv)

    }


}