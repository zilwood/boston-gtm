package com.example.bostonandroid.gtm.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.bostonandroid.gtm.R;
import com.example.bostonandroid.gtm.gtm.TrackableFragment;

public class LoginFragment extends TrackableFragment {
    public static final String TAG = LoginFragment.class.getSimpleName();

    private View rootView;
    private EditText username, password;
    private Button loginButton;
    private CheckBox checkBox;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_login, container, false);

        username = (EditText) rootView.findViewById(R.id.username);
        password = (EditText) rootView.findViewById(R.id.password);
        loginButton = (Button) rootView.findViewById(R.id.login_button);
        checkBox = (CheckBox) rootView.findViewById(R.id.remember_me_checkbox);

        username.setOnFocusChangeListener(this);
        password.setOnFocusChangeListener(this);
        loginButton.setOnClickListener(this);
        checkBox.setOnClickListener(this);

        return rootView;
    }


}
