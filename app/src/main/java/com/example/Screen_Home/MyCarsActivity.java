package com.example.Screen_Home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.projectcar.databinding.ActivityMyCarsBinding;

public class MyCarsActivity extends AppCompatActivity {

    ActivityMyCarsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyCarsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.back.setOnClickListener(view ->{
            finish();
        });
    }
}