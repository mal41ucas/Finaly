package com.example.Screen_Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Screen_Home.MyCarsActivity;
import com.example.Screen_Home.ProfileActivity;
import com.example.Screen_Home.SettingsActivity;
import com.example.Screen_Login_Register.LoginActivity;
import com.example.projectcar.R;
import com.example.projectcar.databinding.FragmentMoreBinding;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MoreFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MoreFragment extends Fragment {

    FragmentMoreBinding binding;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MoreFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MoreFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MoreFragment newInstance(String param1, String param2) {
        MoreFragment fragment = new MoreFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMoreBinding.inflate(inflater);
        binding.cardViewProfile.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), ProfileActivity.class));
            getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });
        binding.clickMyCars.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), MyCarsActivity.class));
            getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });
        binding.clickSettings.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), SettingsActivity.class));
            getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });
        binding.clickPrivacy.setOnClickListener(v -> {
//            startActivity(new Intent(getActivity(),));
            getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });
        binding.btnSignOut.setOnClickListener(v -> {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
            View layoutView = getLayoutInflater().inflate(R.layout.signout_dialog, null);
            TextView out = layoutView.findViewById(R.id.btnSignOutDialoge);
            TextView close = layoutView.findViewById(R.id.btnClose);
            dialogBuilder.setView(layoutView);
            AlertDialog alertDialog = dialogBuilder.create();
            alertDialog.setCancelable(false);

            out.setOnClickListener(view -> {
                startActivity(new Intent(getActivity(), LoginActivity.class));
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                getActivity().finishAffinity();
            });
            close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialog.dismiss();
                }
            });
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            alertDialog.show();
        });
        return binding.getRoot();
    }
}