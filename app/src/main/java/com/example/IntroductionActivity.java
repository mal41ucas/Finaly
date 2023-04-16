package com.example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.animation.AnimationUtils;

import com.example.Adapter.WelcomeAdapter;
import com.example.Screen_Login_Register.LoginActivity;
import com.example.Welcome.AddCarFragment;
import com.example.Welcome.SearchFragment;
import com.example.Welcome.UsersFragment;
import com.example.projectcar.R;
import com.example.projectcar.databinding.ActivityIntroductionBinding;

import java.util.ArrayList;

public class IntroductionActivity extends AppCompatActivity {

    ActivityIntroductionBinding binding;
    ArrayList<Fragment> arrayList;
    WelcomeAdapter adapter;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIntroductionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        preferences = getSharedPreferences("shared",MODE_PRIVATE);
        editor = preferences.edit();

        arrayList = new ArrayList<>();
        arrayList.add(new AddCarFragment());
        arrayList.add(new SearchFragment());
        arrayList.add(new UsersFragment());

        adapter = new WelcomeAdapter(IntroductionActivity.this,arrayList);
        binding.viewPager2.setAdapter(adapter);
        binding.viewPager2.setUserInputEnabled(false);

        binding.btnNext.setOnClickListener(view -> {
            if (binding.viewPager2.getCurrentItem() == 0){
                binding.viewPager2.startAnimation(AnimationUtils.loadAnimation
                        (IntroductionActivity.this, R.anim.fadein_fast));
                binding.viewPager2.setCurrentItem(1);
            }
            else if (binding.viewPager2.getCurrentItem() == 1){
                binding.viewPager2.startAnimation(AnimationUtils.
                        loadAnimation(IntroductionActivity.this, R.anim.fadein_fast));
                binding.viewPager2.setCurrentItem(2);
            }
            else if (binding.viewPager2.getCurrentItem() == 2){
                startActivity(new Intent(getBaseContext(),LoginActivity.class));
                editor.putString("read","yes");
                editor.apply();
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finishAffinity();
            }
        });

        binding.btnBack.setOnClickListener(view -> {
            if (binding.viewPager2.getCurrentItem() == 1){
                binding.viewPager2.startAnimation(AnimationUtils.loadAnimation(IntroductionActivity.this, R.anim.fadein_fast));
                binding.viewPager2.setCurrentItem(0);
            }
            else if (binding.viewPager2.getCurrentItem() == 2){
                binding.viewPager2.startAnimation(AnimationUtils.loadAnimation(IntroductionActivity.this, R.anim.fadein_fast));
                binding.viewPager2.setCurrentItem(1);
            }
        });
        Animation();
    }

    void Animation(){
        binding.imageIconIntro.startAnimation(AnimationUtils.loadAnimation(IntroductionActivity.this, R.anim.lefttoright));
        binding.tvMyCarIntro.startAnimation(AnimationUtils.loadAnimation(IntroductionActivity.this, R.anim.fadein));
        binding.tvDetailsIntro.startAnimation(AnimationUtils.loadAnimation(IntroductionActivity.this, R.anim.fadein));
        binding.cardWelcome.startAnimation(AnimationUtils.loadAnimation(IntroductionActivity.this, R.anim.up_down));
    }
}