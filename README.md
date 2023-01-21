# Applixir Ads Integration: 
# applixir android studio example:
This is an Example on how to add Applixir android Ads in your android app 2023
The project contains java and kotin Examples on how to implement Rewarded Video Ads on native Android Apps - AppLixir:

# Technical content writing about How to Integrate AppLixir Ads to your Android App:
-I helped Writing AppLixir Android Documentations about, How do you use AppLixir sdk to add Video Ads in to your android App or Game.

-Started by testing the previous documentation and edit the code Examples for implementing ads to any Android App, and How to make it less steps, clearer and faster to any android Developer to add ads.

-The Most Important steps I did inn this code enhancements were:
1-show the ads faster by creating a specific class for the webview ( contain ad site) and preparing it, before call it to show ads to the user , with that the ads will be shown faster than the normal webview.
Also by adding the call back interface to this class and that's a step I did to help me to create a connection between the webview and any activity we will use to show ads.

2-create a way of communication between the each android activity and the webview (that AppLixir use to show ads in the app) and how to get user impression for the ad (watch or close the ad in this example) and then move the user to the next activity depend on that impression.

-After Enhancing the previous Sdk Code, which was written in Java only, I also added the same Code Examples in Kotlin, so any Kotlin Android Developer can also add AppLixir Ads to his App or Game.

-The Last Step, was adding explanations to every step to make it clear for any android Dev to Get Started with AppLixir  Video Ads .

# -Article on Applixir:   (Android Sdk Documentations)
# https://support.applixir.com/hc/en-us/sections/360009795313-Android-App-Integration


The Project and Documentation for it. are an UpWork Job to ask for a similar project 
# Contact me:
# https://www.upwork.com/freelancers/~01b430fcce04364da7


USAGE:
How To add Applixir Ads To your android app:
https://github.com/EsraaAkram/ApplixirAdsExample2023

1-adding dependency:
You have 2 options:



First option (add Applixir SDK) :
a-Add the dependency to your gradle:
implementation 'com.github.esraaakram:ApplixirAdsExample2023:1.1.2'
b- make sure that you added jitpack.io to gradle settings:
dependencyResolutionManagement {
repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
repositories {
google()
mavenCentral()
maven { url 'https://jitpack.io' }//this

    }
}















Second option(add Applixir Files Manually) :
a-create kotlin file WebViewApplixirKotlin
copy and paste this custom webview class to it:


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



a-create kotlin file SimplerApplixirHelper
copy and paste this custom SimplerApplixirHelper methods to it:


import android.app.Activity
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.ViewGroup
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

    webViewApplixirKotlin.loadUrl(url)
    webviewContainerRv!!.addView(webViewApplixirKotlin, params)
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


fun hideAndShowWebView(webviewContainerRv: ViewGroup?) {
for (i in 0 until webviewContainerRv?.childCount!!) {
val child: View = webviewContainerRv.getChildAt(i)
if (child is WebViewApplixirKotlin) {

            webviewContainerRv.getChildAt(i).visibility = View.VISIBLE

        } else {
            webviewContainerRv.getChildAt(i).visibility = View.INVISIBLE
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



2-In Manifest:
a-add permissions to manifest: just before application tag

<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />

<uses-permission android:name="com.google.android.gms.permission.AD_ID"/>


b- Allow HTTP and HTTPS to load in your webview :
add usesCleartextTraffic in application tag:
android:usesCleartextTraffic="true"





2-on the xml make sure to use RelativeLayout or ConstraintLayout
As parent view for all in the layout and give it id will will use it to add the add

Example:

<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
xmlns:app="http://schemas.android.com/apk/res-auto"
xmlns:tools="http://schemas.android.com/tools"
android:id="@+id/webviewContainerRv"
android:layout_width="match_parent"
android:layout_height="match_parent"
tools:context=".activities.MainActivityKotlinExample">

    <Button
        android:id="@+id/rewardBtn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerInParent="true"
        android:text="Reward AD!"
        android:textAllCaps="false" />


</RelativeLayout>


















3-In your actvity make sure you create
Java:
private Button rewardBtn;
private RelativeLayout webviewContainerRv;
private WebViewApplixirKotlin webViewApplixirKotlin;
private String url = "https://js.appcdn.net/Android-test-1.html";//add yours

kotlin:
private var rewardBtn: Button? = null
private var webviewContainerRv: RelativeLayout? = null
private var webViewApplixirKotlin: WebViewApplixirKotlin? = null
private val url = "https://js.appcdn.net/Android-test-1.html"


the first one is just the button that will trigger onclick
second is the parent layout in the xmlm in my case it is relative layout, make sure to use relative or constraint layout
the third variable is the webview that will show ads

and add your ads website in the forth variable

4-define my ui (I used findviewbyid you can use binding no problem)
Java:
rewardBtn = findViewById(R.id.rewardBtn);
webviewContainerRv = findViewById(R.id.webviewContainerRv);

kotlin:
rewardBtn = findViewById(R.id.rewardBtn)
webviewContainerRv = findViewById(R.id.webviewContainerRv)





5-loading the ads:
Make sure too load ads early after findviewbyid that will make your ad appear faster
Java:
webViewApplixirKotlin = loadApplixirAd(webviewContainerRv, this, url);

kotlin
webViewApplixirKotlin = loadApplixirAd(webviewContainerRv, this, url)


6-show ads:
Now I will show the add on user click on reward button:
Java:
rewardBtn.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {

        showApplixirAd(webviewContainerRv, webViewApplixirKotlin);
    }
});

kotlin:
rewardBtn!!.setOnClickListener {
showApplixirAd(webviewContainerRv, webViewApplixirKotlin)
}




the full source code in github:
https://github.com/EsraaAkram/ApplixirAdsExample2023
and example of usage :
https://github.com/EsraaAkram/EmptyTest





<!-- 
Article on Applixir:
https://support.applixir.com/hc/en-us/articles/5418083969687-Introduction- --> 
