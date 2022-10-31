package com.example.practice2;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private int oldOrientation = Configuration.ORIENTATION_PORTRAIT;
    private String oldLanguage = "ru";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button changeLangToRu = findViewById(R.id.change_lang_to_ru);
        changeLangToRu.setOnClickListener(this::onClick);

        Button changeLangToEn = findViewById(R.id.change_lang_to_en);
        changeLangToEn.setOnClickListener(this::onClick);
    }

    public void onClick(View v) {
        String lang = "";
        switch (v.getId()) {
            case R.id.change_lang_to_ru:
                lang = "ru";
                break;
            case R.id.change_lang_to_en:
                lang = "en";
                break;
        }
        Configuration newConfig = new Configuration();
        newConfig.setLocale(new Locale(lang));
        getBaseContext().getResources().updateConfiguration(newConfig, getBaseContext().getResources().getDisplayMetrics());
        onConfigurationChanged(newConfig);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation != oldOrientation) {
            String message = "";
            if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                message = "orientation changed to landscape";
            } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
                message = "orientation changed to portrait";
            }

            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            oldOrientation = newConfig.orientation;
        }

        if (!newConfig.locale.getLanguage().equals(oldLanguage)) {
            String message = "";
            if (newConfig.locale.getLanguage().equals("en")) {
                message = "english";
            } else if (newConfig.locale.getLanguage().equals("ru")) {
                message = "russian";
            }

            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            oldLanguage = newConfig.locale.getLanguage();
        }
    }
}