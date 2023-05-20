package com.example.Screen_Login_Register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.example.projectcar.R;
import com.example.projectcar.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnRegister.setOnClickListener(view -> {
            if (binding.dividerMRegister.getVisibility() == View.VISIBLE) {
                Toast.makeText(this, "تاجر", Toast.LENGTH_SHORT).show();
            }
            if (binding.dividerCRegister.getVisibility() == View.VISIBLE) {
                Toast.makeText(this, "مستخدم", Toast.LENGTH_SHORT).show();
            }
        });

        binding.tvSginInRegister.setOnClickListener(view -> {
            startActivity(new Intent(getBaseContext(), LoginActivity.class));
            finishAffinity();
        });

        SelectAccount();
        Anim();
    }

    void SelectAccount() {
        binding.tvMerchantRegister.setOnClickListener(view -> {
            binding.tvMerchantRegister.setBackground(getDrawable(R.drawable.shape_btn_next));
            binding.tvMerchantRegister.setTextColor(getColor(R.color.white));
            binding.tvCustomerRegister.setBackground(getDrawable(R.drawable.shape_edit_login));
            binding.tvCustomerRegister.setTextColor(getColor(R.color.teal_700));
            binding.dividerMRegister.setVisibility(View.VISIBLE);
            binding.dividerCRegister.setVisibility(View.INVISIBLE);
        });
        binding.tvCustomerRegister.setOnClickListener(view -> {
            binding.tvCustomerRegister.setBackground(getDrawable(R.drawable.shape_btn_next));
            binding.tvCustomerRegister.setTextColor(getColor(R.color.white));
            binding.tvMerchantRegister.setBackground(getDrawable(R.drawable.shape_edit_login));
            binding.tvMerchantRegister.setTextColor(getColor(R.color.teal_700));
            binding.dividerCRegister.setVisibility(View.VISIBLE);
            binding.dividerMRegister.setVisibility(View.INVISIBLE);
        });
    }

    void Anim() {
        binding.imageIconRegister.startAnimation(AnimationUtils.loadAnimation
                (getBaseContext(), R.anim.lefttoright));
        binding.tvMyCarRegister.startAnimation(AnimationUtils.loadAnimation
                (getBaseContext(), R.anim.fadein));
        binding.cardRegister.startAnimation(AnimationUtils.loadAnimation
                (getBaseContext(), R.anim.up_down));
    }
}