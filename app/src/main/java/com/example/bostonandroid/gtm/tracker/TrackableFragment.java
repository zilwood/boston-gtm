package com.example.bostonandroid.gtm.tracker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.TagManager;

public class TrackableFragment extends Fragment implements View.OnClickListener, View.OnFocusChangeListener {

    DataLayer dataLayer;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataLayer = TagManager.getInstance(getActivity().getApplicationContext()).getDataLayer();
        dataLayer.pushEvent("StartFragment", DataLayer.mapOf("name", getClass().getSimpleName()));
    }

    @Override
    public void onClick(View view) {
        if (view instanceof CheckBox) {
            dataLayer.pushEvent("Check", DataLayer.mapOf(
                    "name", view.getTag().toString(),
                    "isChecked", ((CheckBox) view).isChecked()
            ));
        } else {
            dataLayer.pushEvent("Click", DataLayer.mapOf("name", view.getTag().toString()));
        }
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        if (view instanceof EditText
                && !view.hasFocus()) {
            EditText text = (EditText) view;
            int inputType = text.getInputType();

            if (inputType != (InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD)
                    && inputType != (InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD)
                    && inputType != (InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)
                    && inputType != (InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_WEB_PASSWORD)) {

                dataLayer.pushEvent("Input", DataLayer.mapOf(
                        "name", view.getTag().toString(),
                        "textInput", text.getText().toString()
                ));
            }
        }
    }
}
