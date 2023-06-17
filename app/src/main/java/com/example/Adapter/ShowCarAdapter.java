package com.example.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Model.ShowCar;
import com.example.projectcar.R;
import com.example.projectcar.databinding.ModelRcHomeBinding;

import java.util.ArrayList;

public class ShowCarAdapter extends RecyclerView.Adapter<ShowCarAdapter.viewHolder> {

    Context context;
    ArrayList<ShowCar> arrayList;

    public ShowCarAdapter(Context context, ArrayList<ShowCar> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewHolder(ModelRcHomeBinding.inflate(LayoutInflater.from(context), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        ShowCar showCar = arrayList.get(position);
        holder.binding.imgViewCar.setImageResource(showCar.getImg());
        holder.binding.checkFavorite.setChecked(showCar.getFavorite());
        holder.binding.tvFullNamePost.setText(showCar.getCarName());
        holder.binding.tvPricePost.setText(showCar.getCarPrice());
        holder.binding.tvTraveledDistance.setText(showCar.getCarTraveledDistance());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {
        ModelRcHomeBinding binding;

        public viewHolder(ModelRcHomeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
