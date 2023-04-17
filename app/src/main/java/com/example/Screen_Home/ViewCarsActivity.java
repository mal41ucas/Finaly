package com.example.Screen_Home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.example.projectcar.R;
import com.example.projectcar.databinding.ActivityViewCarsBinding;

public class ViewCarsActivity extends AppCompatActivity {

    ActivityViewCarsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewCarsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.checkboxFavoriteCar.setOnClickListener(v -> {
            if (binding.checkboxFavoriteCar.isChecked()) {
                binding.checkboxFavoriteCar.setForeground(getDrawable(R.drawable.favorite_checked_24));
                Toast.makeText(this, "Checked", Toast.LENGTH_SHORT).show();
            }
            if (!binding.checkboxFavoriteCar.isChecked()) {
                binding.checkboxFavoriteCar.setForeground(getDrawable(R.drawable.favorite_un_checked_24));
                Toast.makeText(this, "Un Checked", Toast.LENGTH_SHORT).show();
            }
        });

        binding.fABCall.setOnClickListener(view ->{
            Intent goToPhoneCalls = new Intent(Intent.ACTION_DIAL);
            goToPhoneCalls.setData(Uri.parse("tel:0599791805"));
            startActivity(goToPhoneCalls);
        });

    }
}