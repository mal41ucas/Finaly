package com.example.Screen_Login_Register;

import static com.example.Model.NamePrefStatic.EMAIL_REGISTER;
import static com.example.Model.NamePrefStatic.PASSWORD_REGISTER;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.example.Screen_Home.HomeActivity;
import com.example.Screen_Home.ViewCarsActivity;
import com.example.projectcar.R;
import com.example.projectcar.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    SharedPreferences preferences;
    String email, password;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        email = preferences.getString(EMAIL_REGISTER, "");
        password = preferences.getString(PASSWORD_REGISTER, "");

        binding.btnSignIn.setOnClickListener(view -> {
//            if (binding.dividerM.getVisibility() == View.VISIBLE) {
//                startActivity(new Intent(getBaseContext(), HomeActivity.class));
//                finishAffinity();
//            }
//            if (binding.dividerC.getVisibility() == View.VISIBLE) {
//
//            }
            if (binding.edEmailLogin.getText().toString().equals(email)) {
                if (binding.edPasswordLogin.getText().toString().equals(password)) {
                    startActivity(new Intent(getBaseContext(), HomeActivity.class));
                    finishAffinity();
                } else
                    Toast.makeText(this, "الرجاء التأكد من كلمة المرور", Toast.LENGTH_SHORT).show();
            } else
                Toast.makeText(this, "الرجاء التأكد من البريد الإلكتروني", Toast.LENGTH_SHORT).show();
        });

        binding.btnSignUp.setOnClickListener(view -> {
            startActivity(new Intent(getBaseContext(), RegisterActivity.class));
        });

        binding.btnGuest.setOnClickListener(view -> {
//            startActivity(new Intent(getBaseContext(), ViewCarsActivity.class));
        });
        Animation();
        selectAccount();
    }

    void Animation() {
        binding.imageIconLoin.startAnimation(AnimationUtils.loadAnimation(LoginActivity.this, R.anim.lefttoright));
        binding.tvDetailsIntro3.startAnimation(AnimationUtils.loadAnimation(LoginActivity.this, R.anim.fadein));
        binding.tvMyCarLogin.startAnimation(AnimationUtils.loadAnimation(LoginActivity.this, R.anim.fadein));
        binding.cardLogin.startAnimation(AnimationUtils.loadAnimation(LoginActivity.this, R.anim.up_down));
    }

    void selectAccount() {
        binding.tvMerchant.setOnClickListener(view -> {
            binding.tvMerchant.setBackground(getDrawable(R.drawable.shape_btn_next));
            binding.tvMerchant.setTextColor(getColor(R.color.white));
            binding.tvCustomer.setBackground(getDrawable(R.drawable.shape_edit_login));
            binding.tvCustomer.setTextColor(getColor(R.color.teal_700));
            binding.dividerM.setVisibility(View.VISIBLE);
            binding.dividerC.setVisibility(View.INVISIBLE);
        });
        binding.tvCustomer.setOnClickListener(view -> {
            binding.tvCustomer.setBackground(getDrawable(R.drawable.shape_btn_next));
            binding.tvCustomer.setTextColor(getColor(R.color.white));
            binding.tvMerchant.setBackground(getDrawable(R.drawable.shape_edit_login));
            binding.tvMerchant.setTextColor(getColor(R.color.teal_700));
            binding.dividerC.setVisibility(View.VISIBLE);
            binding.dividerM.setVisibility(View.INVISIBLE);
        });
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "إضغط مرة أخرى للخروج", Toast.LENGTH_SHORT).show();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
}