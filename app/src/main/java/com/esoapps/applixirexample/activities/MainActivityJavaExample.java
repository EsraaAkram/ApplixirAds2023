package com.esoapps.applixirexample.activities;

import static com.esoapps.applixirexample.applixirAds.SimplerApplixirHelperKt.loadApplixirAd;
import static com.esoapps.applixirexample.applixirAds.SimplerApplixirHelperKt.showApplixirAd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.esoapps.applixirexample.R;
import com.esoapps.applixirexample.applixirAds.WebViewApplixirKotlin;

public class MainActivityJavaExample extends AppCompatActivity {

    private Button rewardBtn;

    private RelativeLayout webviewContainerRv;
    private WebViewApplixirKotlin webViewApplixirKotlin;

    private String url = "https://js.appcdn.net/Android-test-1.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        itemsDefinitions();

        webViewApplixirKotlin = loadApplixirAd(webviewContainerRv, this, url);

        rewardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showApplixirAd(webviewContainerRv, webViewApplixirKotlin);
            }
        });

    }


    private void itemsDefinitions() {

        rewardBtn = findViewById(R.id.rewardBtn);
        webviewContainerRv = findViewById(R.id.webviewContainerRv);


    }


}