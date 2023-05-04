package com.example.Screen_Home;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.example.Adapter.SelectImageAdapter;
import com.example.projectcar.R;
import com.example.projectcar.databinding.ActivityAddPostBinding;


import java.util.ArrayList;

public class AddPostActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityAddPostBinding binding;
    ArrayList<Uri> list;
    SelectImageAdapter adaptor;
    String colum[] = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddPostBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.back.setOnClickListener(v -> {
            finish();
        });

        list = new ArrayList<>();
        adaptor = new SelectImageAdapter(list);
        binding.rcHomeFragment.setAdapter(adaptor);
        binding.buttonGellary.setOnClickListener(this);
        if ((ActivityCompat.checkSelfPermission(
                AddPostActivity.this, colum[0]) != PackageManager.PERMISSION_GRANTED) &&
                (ActivityCompat.checkSelfPermission(
                        AddPostActivity.this, colum[1]) != PackageManager.PERMISSION_GRANTED)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(colum, 123);
            }
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.buttonGellary:
                openGalley();
                break;
        }

    }

    private void openGalley() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Selcet Picture"), 123);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 123 && resultCode == RESULT_OK) {
            if (data.getClipData() != null) {
                int x = data.getClipData().getItemCount();
                for (int i = 0; i < x; i++) {
                    list.add(data.getClipData().getItemAt(i).getUri());
                }
                adaptor.notifyDataSetChanged();
                binding.tvCountImage.setText(list.size() + "/" + binding.rcHomeFragment.getAdapter().getItemCount());
            } else if (data.getData() != null) {
                String imgurl = data.getData().getPath();
                list.add(Uri.parse(imgurl));
            }
        }
    }
}