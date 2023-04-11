package com.example.Screen_Home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.Adapter.CarAdapter;
import com.example.Adapter.WelcomeAdapter;
import com.example.Model.Car;
import com.example.Screen_Fragment.FavoriteFragment;
import com.example.Screen_Fragment.HomeFragment;
import com.example.Screen_Fragment.MoreFragment;
import com.example.Screen_Fragment.SearchCarFragment;
import com.example.projectcar.R;
import com.example.projectcar.databinding.ActivityHomeBinding;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;
    ArrayList<Car> carArrayList;
    CarAdapter carAdapter;
    ArrayList<Fragment> arrayList;
    WelcomeAdapter adapter;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        arrayList = new ArrayList<>();
        arrayList.add(new HomeFragment());
        arrayList.add(new SearchCarFragment());
        arrayList.add(new FavoriteFragment());
        arrayList.add(new FavoriteFragment());
        arrayList.add(new MoreFragment());

        adapter = new WelcomeAdapter(HomeActivity.this, arrayList);
        binding.viewPagerHome.setAdapter(adapter);
        binding.viewPagerHome.setUserInputEnabled(false);

        binding.bottomNavigationHome.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId = item.getItemId();
                if (itemId == R.id.home_nav) {
                    binding.viewPagerHome.setCurrentItem(0);
                } else if (itemId == R.id.search_nav) {
                    binding.viewPagerHome.setCurrentItem(1);
                } else if (itemId == R.id.add_nav) {
                    binding.viewPagerHome.setCurrentItem(0);
                } else if (itemId == R.id.buy_nav) {
                    binding.viewPagerHome.setCurrentItem(3);
                } else if (itemId == R.id.user_nav) {
                    binding.viewPagerHome.setCurrentItem(4);
                }
                return false;
            }
        });

        binding.viewPagerHome.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                binding.bottomNavigationHome.getMenu().getItem(position).setChecked(true);
            }
        });

        binding.imageAddPost.setOnClickListener(v -> {
            startActivity(new Intent(getBaseContext(), AddPostActivity.class));
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