package com.ixidev.startappads_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.ixidev.startappgdprdialog.GDPRCallback;
import com.ixidev.startappgdprdialog.GDPRDialog;
import com.startapp.android.publish.adsCommon.StartAppAd;
import com.startapp.android.publish.adsCommon.StartAppSDK;

public class MainActivity extends AppCompatActivity implements GDPRCallback {
    public static final String START_APP_ID = "200540351";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        new GDPRDialog(this)
                .create(this, new Runnable() {
                    @Override
                    public void run() {
                        // TODO: 11/01/2019 nothing todo here
                    }
                });
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.item_ads) {
            GDPRDialog.showGdprDialog(null, this, this);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onCLick(View view) {
        StartAppAd.showAd(this); // show Interstitial Ad
        startActivity(new Intent(this, SecondActivity.class));
    }

    @Override
    public void onInitStartAppSdk() {
        StartAppSDK.init(MainActivity.this,
                START_APP_ID, false);
        StartAppAd.disableSplash(); // disable splash ad
        StartAppAd.disableAutoInterstitial(); // disable auto ads

    }

    @Override
    public void onPersonalizedAdsConsentChange(boolean isGranted) {
        StartAppSDK.setUserConsent(this, "pas",
                System.currentTimeMillis(), isGranted);
    }
}
