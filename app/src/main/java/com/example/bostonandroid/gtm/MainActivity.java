package com.example.bostonandroid.gtm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            SampleFragment manualCouponFragment = new SampleFragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.activity_main, manualCouponFragment, SampleFragment.TAG)
                    .commit();
        }
    }
}
