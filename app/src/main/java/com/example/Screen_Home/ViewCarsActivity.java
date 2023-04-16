package com.example.Screen_Home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.projectcar.databinding.ActivityViewCarsBinding;

public class ViewCarsActivity extends AppCompatActivity {

    ActivityViewCarsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewCarsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}