package com.saravana.finance.controller;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.saravana.finance.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                callPartnersList();
            }
        };
        Handler handler = new Handler();
       handler.postDelayed(runnable, 3000);
    }

    private void callPartnersList() {
        Intent intent = new Intent(SplashScreenActivity.this, PartnersList.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
        startActivity(intent);
    }
}
