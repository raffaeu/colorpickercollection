package com.raffaeu.colorpicker;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class PreferenceActivity
        extends android.preference.PreferenceActivity
        implements SharedPreferences.OnSharedPreferenceChangeListener{

    Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);

        this.overridePendingTransition(R.anim.anim_slide_in_left,
                R.anim.anim_slide_out_left);

        setContentView(R.layout.preferences_activity);
        //noinspection deprecation
        addPreferencesFromResource(R.xml.color_preferences);
        toolbar = (Toolbar)findViewById(R.id.toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onStart(){
        super.onStart();
        PreferenceManager.getDefaultSharedPreferences(this)
                .registerOnSharedPreferenceChangeListener(this);

    }

    @Override
    public void onStop(){
        super.onStop();

        PreferenceManager.getDefaultSharedPreferences(this)
                .unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if(key.equals("accent.key")){
            toolbar.setBackgroundColor(sharedPreferences.getInt(key, 0));
        }else{
            Window window = this.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(sharedPreferences.getInt(key, 0));
        }
    }
}
