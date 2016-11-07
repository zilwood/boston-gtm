package com.example.bostonandroid.gtm.login;

import android.os.Bundle;
import android.view.WindowManager;

import com.example.bostonandroid.gtm.R;
import com.example.bostonandroid.gtm.tracker.ContainerHolderSingleton;
import com.example.bostonandroid.gtm.tracker.TrackableActivity;
import com.google.android.gms.tagmanager.ContainerHolder;

import java.util.Timer;
import java.util.TimerTask;

import static android.R.attr.delay;

public class LoginActivity extends TrackableActivity {

    private Timer timer;

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

        // GTM by itself is setup to refresh th container every 12 hours.
        // You can override that o refresh the container as per your own schedule.
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                ContainerHolderSingleton.getContainerHolder().refresh();
            }
        }, 0, 300000); // Setting the timer for 5 min for demo purposes.
    }
}
