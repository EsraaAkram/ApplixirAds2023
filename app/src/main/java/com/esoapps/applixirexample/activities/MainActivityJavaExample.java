package com.esoapps.applixirexample.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import com.esoapps.applixirexample.R;
import com.esoapps.applixirexample.applixirAds.SimplerApplixirAds;
import com.esoapps.applixirexample.applixirAds.WebViewApplixirKotlin;

public class MainActivityJavaExample extends AppCompatActivity {

    private Button rewardBtn;
    private RelativeLayout webviewContainerRv;
    private WebViewApplixirKotlin webViewApplixirKotlin;
    private String url = "https://js.appcdn.net/Android-test-1.html";

    private SimplerApplixirAds simplerApplixirAds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        itemsDefinitions();


        simplerApplixirAds = new SimplerApplixirAds();

        webViewApplixirKotlin = simplerApplixirAds.loadApplixirAd(
                webviewContainerRv, this, url
        );


        rewardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simplerApplixirAds.showApplixirAd(
                        webviewContainerRv,
                        webViewApplixirKotlin
                );
            }
        });


        getOnBackPressedDispatcher().addCallback(this,
                new OnBackPressedCallback(true) {
                    @Override
                    public void handleOnBackPressed() {
                        if (simplerApplixirAds.closeAd(
                                webviewContainerRv,
                                webViewApplixirKotlin
                        ) == false
                    ) {
                            //DO WHATEVER YOU WANT TO DO ON BACK PRESS

                            finish();

                        }

                    }
                });

    }


    private void itemsDefinitions() {

        rewardBtn = findViewById(R.id.rewardBtn);
        webviewContainerRv = findViewById(R.id.webviewContainerRv);


    }


}