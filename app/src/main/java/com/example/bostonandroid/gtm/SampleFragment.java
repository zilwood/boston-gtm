package com.example.bostonandroid.gtm;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.TagManager;

public class SampleFragment extends Fragment {
    public static final String TAG = SampleFragment.class.getSimpleName();

    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_sample, container, false);

        Button login = (Button) rootView.findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Login attempted!");
                DataLayer dataLayer = TagManager.getInstance(getActivity().getApplicationContext()).getDataLayer();
                dataLayer.pushEvent("LoginAttempt", DataLayer.mapOf("click", "LoginButton"));
            }
        });

        return rootView;
    }

}
