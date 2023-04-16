package com.example.Screen_Home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.projectcar.databinding.ActivityPrivacyBinding;

public class PrivacyActivity extends AppCompatActivity {

    ActivityPrivacyBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPrivacyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}