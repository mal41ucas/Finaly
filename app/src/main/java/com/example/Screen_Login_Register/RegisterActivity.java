package com.example.Screen_Login_Register;

import static com.example.Model.NamePrefStatic.EMAIL_REGISTER;
import static com.example.Model.NamePrefStatic.FIRST_NAME;
import static com.example.Model.NamePrefStatic.LAST_NAME;
import static com.example.Model.NamePrefStatic.PASSWORD_REGISTER;
import static com.example.Model.NamePrefStatic.PHONE_NUMBER;
import static com.example.Model.NamePrefStatic.TYPE_USER;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.example.projectcar.R;
import com.example.projectcar.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        editor = preferences.edit();

        binding.btnRegister.setOnClickListener(view -> {
            if (!TextUtils.isEmpty(binding.edFullNameRegister.getText().toString())) {
                if (!TextUtils.isEmpty(binding.edLastName.getText().toString())) {
                    if (!TextUtils.isEmpty(binding.edPhoneNumberRegister.getText().toString())) {
                        if (!TextUtils.isEmpty(binding.edEmailRegister.getText().toString())) {
                            if (!TextUtils.isEmpty(binding.edPasswordRegister.getText().toString()) &&
                                    !TextUtils.isEmpty(binding.edConfirmPasswordRegister.getText().toString())) {
                                if (binding.edPasswordRegister.length() >= 6 && binding.edPasswordRegister.getText().toString().
                                        equals(binding.edConfirmPasswordRegister.getText().toString())) {
                                    if (binding.dividerMRegister.getVisibility() == View.VISIBLE) {
                                        editor.putString(FIRST_NAME, binding.edFullNameRegister.getText().toString());
                                        editor.putString(LAST_NAME, binding.edLastName.getText().toString());
                                        editor.putString(PHONE_NUMBER, binding.edPhoneNumberRegister.getText().toString());
                                        editor.putString(EMAIL_REGISTER,binding.edEmailRegister.getText().toString());
                                        editor.putString(PASSWORD_REGISTER, binding.edPasswordRegister.getText().toString());
                                        editor.putString(TYPE_USER, "تاجر");
                                        editor.apply();
                                        startActivity(new Intent(getBaseContext(),LoginActivity.class));
                                        finishAffinity();
                                    }
                                    if (binding.dividerCRegister.getVisibility() == View.VISIBLE) {
                                        editor.putString(FIRST_NAME, binding.edFullNameRegister.getText().toString());
                                        editor.putString(LAST_NAME, binding.edLastName.getText().toString());
                                        editor.putString(PHONE_NUMBER, binding.edPhoneNumberRegister.getText().toString());
                                        editor.putString(EMAIL_REGISTER,binding.edEmailRegister.getText().toString());
                                        editor.putString(PASSWORD_REGISTER, binding.edPasswordRegister.getText().toString());
                                        editor.putString(TYPE_USER, "مستخدم");
                                        editor.apply();
                                        startActivity(new Intent(getBaseContext(),LoginActivity.class));
                                        finishAffinity();
                                    }
                                } else
                                    Toast.makeText(getBaseContext(), "كلمة المرور ليست متطابقة", Toast.LENGTH_SHORT).show();
                            } else
                                Toast.makeText(getBaseContext(), "تأكد من كلمة المرور و تكون من ستة حروف او اكتر", Toast.LENGTH_SHORT).show();
                        } else
                            Toast.makeText(getBaseContext(), "تأكد من البريد الإلكتروني", Toast.LENGTH_SHORT).show();
                    } else
                        Toast.makeText(getBaseContext(), "تأكد من رقم الهاتف", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(getBaseContext(), "تأكد من الإسم الاخير", Toast.LENGTH_SHORT).show();
            } else
                Toast.makeText(getBaseContext(), "تأكد من الإسم الاول", Toast.LENGTH_SHORT).show();
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