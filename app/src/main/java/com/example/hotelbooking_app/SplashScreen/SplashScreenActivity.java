package com.example.hotelbooking_app.SplashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.hotelbooking_app.Homescreen.HomescreenActivity;
import com.example.hotelbooking_app.Login.Activity.LoginActivity;
import com.example.hotelbooking_app.Login.AsynTask.RefreshPasswordAsyntask;
import com.example.hotelbooking_app.Login.AuthService.AuthEnpoint;
import com.example.hotelbooking_app.Login.AuthService.AuthenticationCallback;
import com.example.hotelbooking_app.R;

import java.util.Objects;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SplashScreenActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_layout);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    String jwtToken = sharedPreferences.getString("jwtKey", null);
                    long lastPuttedJwtTime = sharedPreferences.getLong("lastPuttedJwtTime", 0);

                    if (!TextUtils.isEmpty(jwtToken) && lastPuttedJwtTime != 0 &&
                            (System.currentTimeMillis() - lastPuttedJwtTime < 5 * 60 * 1000)) {
                        navigateToMain();
                    } else {
                        navigateToLogin();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    navigateToLogin();
                }
            }
        }, 2000);

    }

    private void navigateToMain() {
        Intent mainIntent = new Intent(SplashScreenActivity.this, HomescreenActivity.class);
        startActivity(mainIntent);
        finish();
    }

    private void navigateToLogin() {
        Intent loginIntent = new Intent(SplashScreenActivity.this, LoginActivity.class);
        startActivity(loginIntent);
        finish();
    }
}