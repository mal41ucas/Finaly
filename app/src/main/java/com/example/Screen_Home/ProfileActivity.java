package com.example.Screen_Home;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectcar.R;
import com.example.projectcar.databinding.ActivityProfileBinding;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class ProfileActivity extends AppCompatActivity {

    ActivityProfileBinding binding;
    private static final int RESULT_LOAD_IMG = 0;
    String photo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.back.setOnClickListener(view -> {
            finish();
        });

        binding.btnEditProfile.setOnClickListener(v -> {
            startActivity(new Intent(getBaseContext(), EditProfileActivity.class));
        });

        binding.imgEditPhotoUser.setOnClickListener(v -> {
            Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
            photoPickerIntent.setType("image/*");
            photo = "small";
            startActivityForResult(photoPickerIntent, RESULT_LOAD_IMG);
        });

        binding.imgEditUserProfile.setOnClickListener(v -> {
            Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
            photoPickerIntent.setType("image/*");
            photo = "big";
            startActivityForResult(photoPickerIntent, RESULT_LOAD_IMG);
        });
    }

    @Override
    protected void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            try {
                final Uri imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                if (photo.equals("small")) {
                    binding.imgUserProfile.setImageBitmap(selectedImage);
                } else if (photo.equals("big")) {
                    binding.imgBackground.setImageBitmap(selectedImage);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(ProfileActivity.this, "حدث خطأ ما", Toast.LENGTH_LONG).show();
            }

        } else {
            Toast.makeText(ProfileActivity.this, "لم يتم إختيار صورة", Toast.LENGTH_LONG).show();
        }
    }
}