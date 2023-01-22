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



FIRST OPTION (add Applixir SDK) :
a-Add the dependency to your gradle:
implementation 'com.github.esraaakram:ApplixirAdsExample2023:1.1.2'
b- make sure that you added jitpack.io to gradle settings:
maven { url 'https://jitpack.io' }




SECOND OPTION (add Applixir Files Manually) :
create kotlin files WebViewApplixirKotlin and SimplerApplixirHelper
copy and paste this classes to it:
WebViewApplixirKotlin and SimplerApplixirHelper



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





3-In your actvity:



-Loading the ads:
Make sure too load ads early after findviewbyid that will make your ad appear faster


webViewApplixirKotlin = loadApplixirAd(webviewContainerRv, this, url) //webviewContainerRv is the parent layout in xml





-show ads:

showApplixirAd(webviewContainerRv, webViewApplixirKotlin);


the full source code in github:
https://github.com/EsraaAkram/ApplixirAdsExample2023
and example of usage :
https://github.com/EsraaAkram/EmptyTest





<!-- 
Article on Applixir:
https://support.applixir.com/hc/en-us/articles/5418083969687-Introduction- --> 
