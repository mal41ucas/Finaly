package com.example.Screen_Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Toast;


import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.Adapter.ShowCarAdapter;
import com.example.Database.CarDao;
import com.example.Database.getCarDatabase;
import com.example.Interface.OnItemClickListener;
import com.example.Model.Car;
import com.example.Model.ShowCar;
import com.example.projectcar.R;
import com.example.projectcar.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class HomeFragment extends Fragment {

    RequestQueue requestQueue;
    FragmentHomeBinding binding;
    private static getCarDatabase carDatabase;
    CarDao carDao;
    ShowCarAdapter showCarAdapter;
    ArrayList<ShowCar> showCars;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }


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

        carDatabase = Room.databaseBuilder(getContext(), getCarDatabase.class, "car-database").allowMainThreadQueries().build();
        carDao = HomeFragment.getCarDatabase().carDao();

        ArrayList<String> yearsList = new ArrayList<>();
        int current_year = Calendar.getInstance().get(Calendar.YEAR);
        int count = 60;

        for (int i = 0; i < count; i++) {
            yearsList.add(Integer.toString(current_year - i));
        }
        ArrayAdapter<String> yearsAdapter = new ArrayAdapter<>
                (getActivity(), android.R.layout.simple_spinner_item, yearsList);
        binding.spinnerYear.setAdapter(yearsAdapter);

        showCars = new ArrayList<>();

//        carDao.deleteCar(1);
//        carDao.deleteCar(2);
//        carDao.deleteCar(3);
//        carDao.deleteCar(4);

        ShowCar car1 = new ShowCar(R.drawable.cover_1, R.drawable.p_1, "بي أم", "41200", "430", "MOUSAB", "اوتوماتيك", "بيت حنون", false,
                "زودت إيه 8 بمحرك مكون من ثمانية اسطوانات سعة 4.2 لتر يولد قوة 372 حصان عند 3500 دورة بالدقيقة يمكنها من التسارع من 0 إلى 100 كلم بالساعة بغضون 5.7 ثانية وسرعة قصوى تصل إلى 250 كلم مثبتة إلكترونيا"
        );
        ShowCar car2 = new ShowCar(R.drawable.cover_2, R.drawable.p_2, "نمبرجين", "37800", "430", "Shukri", "اوتوماتيك", "الوسطى", false,
                "زودت إيه 8 بمحرك مكون من ثمانية اسطوانات سعة 4.2 لتر يولد قوة 372 حصان عند 3500 دورة بالدقيقة يمكنها من التسارع من 0 إلى 100 كلم بالساعة بغضون 5.7 ثانية وسرعة قصوى تصل إلى 250 كلم مثبتة إلكترونيا"
        );
        ShowCar car3 = new ShowCar(R.drawable.cover_3, R.drawable.p_3, "تسلا", "96200", "430", "Ahmad", "اوتوماتيك", "بيت لاهيا", false,
                "زودت إيه 8 بمحرك مكون من ثمانية اسطوانات سعة 4.2 لتر يولد قوة 372 حصان عند 3500 دورة بالدقيقة يمكنها من التسارع من 0 إلى 100 كلم بالساعة بغضون 5.7 ثانية وسرعة قصوى تصل إلى 250 كلم مثبتة إلكترونيا"
        );
        ShowCar car4 = new ShowCar(R.drawable.cover_4, R.drawable.p_2, "نمبرجين", "109700", "430", "Muhammad", "اوتوماتيك", "غزة", false,
                "زودت إيه 8 بمحرك مكون من ثمانية اسطوانات سعة 4.2 لتر يولد قوة 372 حصان عند 3500 دورة بالدقيقة يمكنها من التسارع من 0 إلى 100 كلم بالساعة بغضون 5.7 ثانية وسرعة قصوى تصل إلى 250 كلم مثبتة إلكترونيا"
        );
        ShowCar car5 = new ShowCar(R.drawable.cover_5, R.drawable.p_1, "أودي", "85400", "430", "Mustafa", "اوتوماتيك", "رفح", false,
                "زودت إيه 8 بمحرك مكون من ثمانية اسطوانات سعة 4.2 لتر يولد قوة 372 حصان عند 3500 دورة بالدقيقة يمكنها من التسارع من 0 إلى 100 كلم بالساعة بغضون 5.7 ثانية وسرعة قصوى تصل إلى 250 كلم مثبتة إلكترونيا"
        );
        showCars.add(car1);
        showCars.add(car2);
        showCars.add(car3);
        showCars.add(car4);
        showCars.add(car5);
        showCars.add(car1);
        showCars.add(car2);
        showCars.add(car3);
        showCars.add(car4);
        showCars.add(car5);

//        carDao.insertCar(car1);
//        carDao.insertCar(car2);
//        carDao.insertCar(car3);
//        carDao.insertCar(car4);

//        List<ShowCar> carList = carDao.getAllCars();

        showCarAdapter = new ShowCarAdapter(getActivity(), showCars);
        binding.rcHomeShowCars.setAdapter(showCarAdapter);
        ShowAndHideFilter();
        return binding.getRoot();
    }


    public static getCarDatabase getCarDatabase() {
        return carDatabase;
    }


    void getAllCars2() {
        requestQueue = Volley.newRequestQueue(getActivity());
//        StringRequest stringRequest = new StringRequest(GET, "http://10.0.2.2:8000/api/car", new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                try {
//                    JSONObject jsonObject = new JSONObject(response);
//                    JSONArray jsonArray = jsonObject.getJSONArray("data");
//                    JSONObject jsonObject1;
//                    for (int i = 0; i < jsonArray.length(); i++) {
//                        jsonObject1 = jsonArray.getJSONObject(i);
//                        message = jsonObject1.getString("fullName");
//                        Toast.makeText(getActivity(), "/"+message, Toast.LENGTH_LONG).show();
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//        requestQueue.add(stringRequest);
    }

    void showAllCars() {
        requestQueue = Volley.newRequestQueue(getActivity());
//        StringRequest stringRequest = new StringRequest(GET, "http://localhost:8000/api/car", new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                try {
//                    JSONObject jsonObject = new JSONObject(response);
//                    JSONArray jsonArray = jsonObject.getJSONArray("data");
//                    message = jsonObject.getString("message");
////                    for (int i = 0 ; i < jsonArray.length(); i++){
////                        JSONObject jsonObject1;
////                        jsonObject1 = jsonArray.getJSONObject(1);
////                        message = jsonObject1.getString("carModel");
//                        Toast.makeText(getActivity(), "any "+message, Toast.LENGTH_SHORT).show();
////                    }
//                }catch (JSONException e){
//                    e.printStackTrace();
//                }
//
//            }
//        },new Response.ErrorListener(){
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                error.printStackTrace();
//            }
//        });
//        requestQueue.add(stringRequest);


        // second try
//        try {
//            URL url = new URL("http://localhost:3306/api/car");
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//
//            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//            String inputLine;
//            StringBuffer response = new StringBuffer();
//
//            while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
//            }
//
//            in.close();
//            Toast.makeText(getActivity(), ""+response.toString(), Toast.LENGTH_LONG).show();
//            System.out.println(response.toString());
//        } catch (Exception e) {
//            System.err.println("Error: " + e.getMessage());
//            Toast.makeText(getActivity(), ""+e.getMessage(), Toast.LENGTH_SHORT).show();
//        }
    }


    void ShowAndHideFilter() {
        binding.btnFilter.setOnClickListener(v -> {
            if (binding.carViewFilter.getVisibility() == View.GONE) {
                binding.carViewFilter.setVisibility(View.VISIBLE);
                binding.btnFilter.setBackgroundResource(R.drawable.filter_checked);
                binding.carViewFilter.startAnimation(AnimationUtils.loadAnimation(getActivity(),
                        R.anim.fadein_faster));
            } else if (binding.carViewFilter.getVisibility() == View.VISIBLE) {
                binding.carViewFilter.setVisibility(View.GONE);
                binding.btnFilter.setBackgroundResource(R.drawable.filter_unchecked);
                binding.carViewFilter.startAnimation(AnimationUtils.loadAnimation(getActivity(),
                        R.anim.fadeout));
            }
        });
    }


}