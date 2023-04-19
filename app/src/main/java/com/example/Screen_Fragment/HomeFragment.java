package com.example.Screen_Fragment;

import static com.android.volley.Request.Method.GET;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.util.LogPrinter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Toast;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.projectcar.R;
import com.example.projectcar.databinding.FragmentHomeBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    RequestQueue requestQueue;
    FragmentHomeBinding binding;
    String message;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        binding = FragmentHomeBinding.inflate(inflater);
        ArrayList<String> yearsList = new ArrayList<>();
        int current_year = Calendar.getInstance().get(Calendar.YEAR);
        int count = 60;
        showAllCars();
        for (int i = 0; i < count; i++) {
            yearsList.add(Integer.toString(current_year - i));
        }
        ArrayAdapter<String> yearsAdapter = new ArrayAdapter<>
                (getActivity(), android.R.layout.simple_spinner_item, yearsList);
        binding.spinnerYear.setAdapter(yearsAdapter);
        ShowAndHideFilter();
        return binding.getRoot();
    }

    void showAllCars(){
        requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest(GET, "http://127.0.0.1:8000/api/car", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    JSONObject jsonObject1;
                    jsonObject1 = jsonArray.getJSONObject(1);
                    message = jsonObject1.getString("carModel");
                    Toast.makeText(getActivity(), "any "+message, Toast.LENGTH_SHORT).show();
                }catch (JSONException e){
                    e.printStackTrace();
                }

            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
    }

    void ShowAndHideFilter(){
        if (binding.carViewFilter.getVisibility() == View.GONE){
            binding.btnShowFilter.setText("عرض");
        } else if (binding.carViewFilter.getVisibility() == View.VISIBLE){
            binding.btnShowFilter.setText("إخفاء");
        }
        binding.btnShowFilter.setOnClickListener(v -> {
            if (binding.carViewFilter.getVisibility() == View.GONE){
                binding.carViewFilter.setVisibility(View.VISIBLE);
                binding.btnShowFilter.setText("إخفاء");
                binding.carViewFilter.startAnimation(AnimationUtils.loadAnimation(getActivity(),
                        R.anim.fadein_faster));
            } else if (binding.carViewFilter.getVisibility() == View.VISIBLE){
                binding.carViewFilter.setVisibility(View.GONE);
                binding.btnShowFilter.setText("عرض");
                binding.carViewFilter.startAnimation(AnimationUtils.loadAnimation(getActivity(),
                        R.anim.fadeout));
            }
        });
    }
}