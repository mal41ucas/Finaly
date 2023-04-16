package com.example.Screen_Home;

import androidx.appcompat.app.AppCompatActivity;

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

        binding.imgFavoriteCar.setOnClickListener(v -> {
            binding.imgFavoriteCar.setImageDrawable(getDrawable(R.drawable.baseline_favorite_24));
            Toast.makeText(this, "Favorite", Toast.LENGTH_SHORT).show();
        });
    }
}