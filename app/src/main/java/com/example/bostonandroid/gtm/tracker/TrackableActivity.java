package com.example.bostonandroid.gtm.tracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.TagManager;

public class TrackableActivity extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener{
    DataLayer dataLayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataLayer = TagManager.getInstance(getApplicationContext()).getDataLayer();
        dataLayer.pushEvent("StartActivity", DataLayer.mapOf("name", getClass().getSimpleName()));
    }

    @Override
    protected void onResume() {
        super.onResume();
        dataLayer.pushEvent("ResumeActivity", DataLayer.mapOf("name", getClass().getSimpleName()));
    }

    @Override
    public void onClick(View view) {
        if (view instanceof CheckBox) {
            if(!((CheckBox) view).isChecked()){
                dataLayer.push("check_box", view.getTag().toString() + ": " + false);
            }
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

                dataLayer.push("input", view.getTag().toString() + ": " + text.getText().toString());
            }
        }
    }
}
