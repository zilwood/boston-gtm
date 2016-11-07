package com.example.bostonandroid.gtm.login;

import android.os.Bundle;
import android.view.WindowManager;

import com.example.bostonandroid.gtm.R;
import com.example.bostonandroid.gtm.tracker.TrackableActivity;

public class LoginActivity extends TrackableActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        if (savedInstanceState == null) {
            LoginFragment manualCouponFragment = new LoginFragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.activity_main, manualCouponFragment, LoginFragment.TAG)
                    .commit();
        }
    }
}
