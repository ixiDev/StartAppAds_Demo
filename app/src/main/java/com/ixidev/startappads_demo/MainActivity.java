package com.ixidev.startappads_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.startapp.android.publish.adsCommon.StartAppAd;
import com.startapp.android.publish.adsCommon.StartAppSDK;

public class MainActivity extends AppCompatActivity {
    public static final String START_APP_ID = "200540351";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO: 09/01/2019 init StartApp SDK
        StartAppSDK.init(MainActivity.this,
                START_APP_ID, false);
        StartAppAd.disableSplash(); // disable splash ad
        StartAppAd.disableAutoInterstitial(); // disable auto ads

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onCLick(View view) {
        StartAppAd.showAd(this); // show Interstitial Ad
        startActivity(new Intent(this, SecondActivity.class));
    }
}
