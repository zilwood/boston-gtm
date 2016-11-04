package com.example.bostonandroid.gtm.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.bostonandroid.gtm.R;
import com.example.bostonandroid.gtm.gtm.TrackableFragment;

public class LoginFragment extends TrackableFragment {
    public static final String TAG = LoginFragment.class.getSimpleName();

    private View rootView;
    private Button loginButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_login, container, false);

        loginButton = (Button) rootView.findViewById(R.id.login_button);

        return rootView;
    }


}
