package com.example.Screen_Home;

import static com.example.Model.NamePrefStatic.EMAIL_REGISTER;
import static com.example.Model.NamePrefStatic.FIRST_NAME;
import static com.example.Model.NamePrefStatic.LAST_NAME;
import static com.example.Model.NamePrefStatic.PHONE_NUMBER;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.Screen_Login_Register.LoginActivity;
import com.example.projectcar.R;
import com.example.projectcar.databinding.ActivityEditProfileBinding;

public class EditProfileActivity extends AppCompatActivity {

    ActivityEditProfileBinding binding;
    SharedPreferences preferences;
    String firstName,lastName, email,phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        email = preferences.getString(EMAIL_REGISTER, "");
        firstName = preferences.getString(FIRST_NAME, "");
        lastName = preferences.getString(LAST_NAME, "");
        phone = preferences.getString(PHONE_NUMBER, "");

        binding.tvEditName.setText(firstName+" "+lastName);
        binding.tvEditEmail.setText(email);
        binding.tvEditPhone.setText(phone);
        binding.tvEditAddress.setText("فلسطين - غزة");

        binding.back.setOnClickListener(v -> {
            finish();
        });
    }
}