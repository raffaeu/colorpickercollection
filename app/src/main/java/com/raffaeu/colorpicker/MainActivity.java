package com.raffaeu.colorpicker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.raffaeu.colorpickerlib.ColorPickerDialog;

public class MainActivity
        extends AnimActivity
        implements View.OnClickListener{

    private final String TAG = "com.raffaeu.colorpicker";

    private Button buttonPreferences;
    private Button buttonDialog;

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);

        setContentView(R.layout.main_activity);

        buttonPreferences = (Button)findViewById(R.id.button_preferences);
        buttonDialog = (Button)findViewById(R.id.button_dialog);

        buttonPreferences.setOnClickListener(this);
        buttonDialog.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button_preferences:
                Intent intent = new Intent(MainActivity.this, PreferenceActivity.class);
                startActivity(intent);
                break;
            case R.id.button_dialog:

                break;
            default:
                break;
        }
    }
}
