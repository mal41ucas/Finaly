package com.example.Screen_Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;


import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.Adapter.ShowCarAdapter;
import com.example.Database.CarDao;
import com.example.Database.getCarDatabase;
import com.example.Model.Car;
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
    ArrayList<Car> cars;
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

        cars = new ArrayList<>();

//        carDao.deleteCar(1);
//        carDao.deleteCar(2);
//        carDao.deleteCar(3);
//        carDao.deleteCar(4);

//            Car car1 = new Car(1, "BMW", true, 20000, 15000, "Sedan", 2013, 1500, "High Material Quality", "Gas", "Red", "Automatic", "BMW","Gaza");
//            Car car2 = new Car(2, "Fiat", true, 10000, 10000, "Combat", 2010, 2000, "High Material Quality", "Gas", "Red", "Automatic", "BMW","Rafah");
//            Car car3 = new Car(3, "Mazda", true, 150000, 15000, "HatchBack", 2020, 1600, "High Material Quality", "Gas", "Red", "Automatic", "BMW","Remal");
//            Car car4 = new Car(4, "Mercedes", true, 15000, 15000, "Luxury", 2023, 6500, "High Material Quality", "Gas", "Red", "Automatic", "BMW","Khanyouns");
//
//            cars.add(car1);
//            cars.add(car2);
//            cars.add(car3);
//            cars.add(car4);
//
//            carDao.insertCar(car1);
//            carDao.insertCar(car2);
//            carDao.insertCar(car3);
//            carDao.insertCar(car4);

        List<Car> carList = carDao.getAllCars();

        showCarAdapter = new ShowCarAdapter(getActivity(), carList);
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