package com.example.bostonandroid.gtm.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bostonandroid.gtm.R;
import com.example.bostonandroid.gtm.tracker.ContainerHolderSingleton;
import com.example.bostonandroid.gtm.tracker.TrackableFragment;
import com.google.android.gms.tagmanager.Container;

public class LoginFragment extends TrackableFragment {
    public static final String TAG = LoginFragment.class.getSimpleName();

    private View rootView;
    private EditText username, password;
    private Button loginButton;
    private CheckBox checkBox;
    private TextView quoteTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_login, container, false);

        username = (EditText) rootView.findViewById(R.id.username);
        password = (EditText) rootView.findViewById(R.id.password);
        loginButton = (Button) rootView.findViewById(R.id.login_button);
        checkBox = (CheckBox) rootView.findViewById(R.id.remember_me_checkbox);
        quoteTextView = (TextView) rootView.findViewById(R.id.quote);

        username.setOnFocusChangeListener(this);
        password.setOnFocusChangeListener(this);
        loginButton.setOnClickListener(this);
        checkBox.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        String quote = getQuote();
        if(quote != null && !quote.isEmpty()){
            quoteTextView.setVisibility(View.VISIBLE);
            quoteTextView.setText(getString(R.string.quote_header));
            String[] split = quote.split("-");
            quoteTextView.append(split[0] + "\t - " + split[1]);
        }
    }

    private String getQuote() {
        Container container = ContainerHolderSingleton.getContainerHolder().getContainer();
        return container.getString("quote");
    }
}
