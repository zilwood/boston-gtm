package com.example.bostonandroid.gtm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.TagManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            SampleFragment manualCouponFragment = new SampleFragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.activity_main, manualCouponFragment, SampleFragment.TAG)
                    .commit();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        DataLayer dataLayer = TagManager.getInstance(getApplicationContext()).getDataLayer();
        dataLayer.pushEvent("AppVisit", DataLayer.mapOf("screenName", "Login"));
    }
}
