package com.example.practice2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int oldOrientation = Configuration.ORIENTATION_UNDEFINED;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation != oldOrientation) {
            String message = "";
            if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                message = "orientation changed to landscape";
            } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
                message = "orientation changed to portrait";
            }

            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            oldOrientation = newConfig.orientation;
        }
    }

}