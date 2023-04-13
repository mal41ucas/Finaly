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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.cardImgProfile.startAnimation(AnimationUtils.loadAnimation(getBaseContext(),R.anim.fadein));
        binding.dataProfile.startAnimation(AnimationUtils.loadAnimation(getBaseContext(),R.anim.fadein));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            binding.imgActivity.setRenderEffect(RenderEffect.createBlurEffect(60, 60, Shader.TileMode.MIRROR));
        }
        binding.imgEditProfile.setOnClickListener(v -> {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(ProfileActivity.this);
            View layoutView = getLayoutInflater().inflate(R.layout.model_data_profile, null);
            Button btnDone = layoutView.findViewById(R.id.btnSave);
            Button btnCancel = layoutView.findViewById(R.id.btnCancel);
            TextView edFirstName = layoutView.findViewById(R.id.edFirstName);
            TextView edLastName = layoutView.findViewById(R.id.edLastName);
            TextView edPhoneNumber = layoutView.findViewById(R.id.edPhoneNumber);
            TextView edPasswordEdit = layoutView.findViewById(R.id.edPasswordEdit);
            TextView edPasswordConfirmEdit = layoutView.findViewById(R.id.edPasswordConfirmEdit);
            dialogBuilder.setView(layoutView);
            AlertDialog alertDialog = dialogBuilder.create();
            alertDialog.setCancelable(false);

            btnDone.setOnClickListener(view -> {
                if (!TextUtils.isEmpty(edFirstName.getText().toString())) {
                    if (!TextUtils.isEmpty(edLastName.getText().toString())) {
                        if (!TextUtils.isEmpty(edPhoneNumber.getText().toString())) {
                            if (edPhoneNumber.getText().toString().length() == 10) {
                                if (!TextUtils.isEmpty(edPasswordEdit.getText().toString()) && edPasswordEdit.getText().toString().length() >= 6) {
                                    if (edPasswordEdit.getText().toString().equals(edPasswordConfirmEdit.getText().toString())) {
                                        binding.tvNameUserProfile.setText(edFirstName.getText().toString()
                                                + " " + edLastName.getText().toString());
                                        binding.tvPhoneProfile.setText(edPhoneNumber.getText().toString());
                                        binding.tvPasswordProfile.setText(edPasswordEdit.getText().toString());
                                        alertDialog.dismiss();
                                    } else {
                                        Toast.makeText(this, "كلمة المرور ليست متطابقة", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(this, "أدخل كلمة المرور 6 حروف على الأقل", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(this, "يجب ان يكون رقم الهاتف 10 أرقام", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(this, "أدخل رقم الهاتف", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, "أدخل الإسم الأخير", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "أدخل الإسم الأول", Toast.LENGTH_SHORT).show();
                }
            });
            btnCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialog.dismiss();
                }
            });
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            alertDialog.show();
        });

        binding.editPhoto.setOnClickListener(v -> {
            Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
            photoPickerIntent.setType("image/*");
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
                binding.imgUserProfile.setImageBitmap(selectedImage);
                binding.imgActivity.setImageBitmap(selectedImage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(ProfileActivity.this, "حدث خطأ ما", Toast.LENGTH_LONG).show();
            }

        } else {
            Toast.makeText(ProfileActivity.this, "لم يتم إختيار صورة", Toast.LENGTH_LONG).show();
        }
    }
}