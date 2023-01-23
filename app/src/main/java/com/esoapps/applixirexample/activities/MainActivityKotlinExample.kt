package com.esoapps.applixirexample.activities

import android.os.Bundle
import android.widget.Button
import android.widget.RelativeLayout
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.esoapps.applixirexample.R
import com.esoapps.applixirexample.applixirAds.SimplerApplixirAds
import com.esoapps.applixirexample.applixirAds.WebViewApplixirKotlin
import com.esoapps.applixirexample.applixirAds.loadApplixirAd
import com.esoapps.applixirexample.applixirAds.showApplixirAd


class MainActivityKotlinExample : AppCompatActivity() {

    private var rewardBtn: Button? = null

    private var webviewContainerRv: RelativeLayout? = null
    private var webViewApplixirKotlin: WebViewApplixirKotlin? = null

    private val url = "https://js.appcdn.net/Android-test-1.html"

    private var simplerApplixirAds: SimplerApplixirAds? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_act)


        itemsDefinitions()


        //loadApplixirAd(webviewContainerRv, this, url)

        simplerApplixirAds = SimplerApplixirAds()

        webViewApplixirKotlin = simplerApplixirAds?.loadApplixirAd(
            webviewContainerRv, this, url
        )

        rewardBtn!!.setOnClickListener {

            //showApplixirAd(webviewContainerRv, webViewApplixirKotlin)

            simplerApplixirAds?.showApplixirAd(
                webviewContainerRv,
                webViewApplixirKotlin
            )

        }

        onBackPressedDispatcher.addCallback(this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {

                    if (simplerApplixirAds?.closeAd(
                            webviewContainerRv,
                            webViewApplixirKotlin
                        ) == false
                    ) {
                        //DO WHATEVER YOU WANT TO DO ON BACK PRESS

                        finish()

                    }

                }
            })


    }


    private fun itemsDefinitions() {

        rewardBtn = findViewById(R.id.rewardBtn)
        webviewContainerRv = findViewById(R.id.webviewContainerRv)

    }


}