package com.example.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.Model.Car;
import com.example.projectcar.R;

import java.util.ArrayList;

public class CarAdapter extends BaseAdapter {
    Context context;
    ArrayList<Car> car_arrayList;

    public CarAdapter(Context context, ArrayList<Car> cars_arrayList) {
        this.context = context;
        this.car_arrayList = cars_arrayList;
    }

    @Override
    public int getCount() {
        return car_arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return car_arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View view1 = LayoutInflater.from(context).inflate(R.layout.car_item, null);
        ImageView imageView = view1.findViewById(R.id.image);
        Car car = car_arrayList.get(i);
//        imageView.setImageDrawable(car.getImage());
        return view1;
    }
}
