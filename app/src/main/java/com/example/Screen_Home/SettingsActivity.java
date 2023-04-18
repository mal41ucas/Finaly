package com.example.Screen_Home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.CompoundButton;

import com.example.projectcar.R;
import com.example.projectcar.databinding.ActivitySettingsBinding;

public class SettingsActivity extends AppCompatActivity {

    ActivitySettingsBinding binding;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = preferences.edit();

        binding.tvDarkTheme.setOnClickListener(v -> {
            if (binding.tvDarkTheme.getText().toString().equals("تفعيل")){
                binding.tvDarkTheme.setText("إيقاف");
                binding.tvDarkTheme.setTextColor(getColor(R.color.teal_700));
                editor.putString("theme","dark");
                editor.apply();
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else if (binding.tvDarkTheme.getText().toString().equals("إيقاف")){
                binding.tvDarkTheme.setText("تفعيل");
                binding.tvDarkTheme.setTextColor(getColor(R.color.purple_500));
                editor.putString("theme","whit");
                editor.apply();
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        });

        binding.tvBack.setOnClickListener(v -> {

        });
    }

    @Override
    public void recreate() {
        startActivity(getIntent());
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finishAffinity();
    }
}