package com.example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.animation.AnimationUtils;

import com.example.Screen_Login_Register.LoginActivity;
import com.example.projectcar.R;
import com.example.projectcar.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    SharedPreferences preferences;
    String scan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        preferences = getSharedPreferences("shared",MODE_PRIVATE);
        scan = preferences.getString("read","");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2500);
                    if (scan.equals("yes")){
                        startActivity(new Intent(getBaseContext(), LoginActivity.class));
                        finishAffinity();
                    } else {
                        startActivity(new Intent(getBaseContext(), IntroductionActivity.class));
                        finishAffinity();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Animation();
    }

    void Animation() {

        binding.imageViewIcon.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.lefttoright));
        binding.imageViewTop.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.fadein));
        binding.imageViewBottom.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.fadein));
        binding.tvDetailsSplash.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.fadein));
        binding.tvMyCarSplash.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.fadein));
    }
}