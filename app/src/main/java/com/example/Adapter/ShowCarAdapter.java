package com.example.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Model.Car;
import com.example.Screen_Home.ViewCarsActivity;
import com.example.projectcar.R;
import com.example.projectcar.databinding.ModelRcHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class ShowCarAdapter extends RecyclerView.Adapter<ShowCarAdapter.viewHolder> {

    Context context;
    List<Car> arrayList;

    public ShowCarAdapter(Context context, List<Car> arrayList) {
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
        Car car = arrayList.get(position);
        holder.binding.imgViewCar.setImageResource(R.drawable.audi);

        holder.binding.checkFavorite.setOnClickListener(v ->{
            if (holder.binding.checkFavorite.isChecked()) {
                holder.binding.checkFavorite.setForeground(context.getDrawable(R.drawable.favorite_checked_24));
                Toast.makeText(context.getApplicationContext(), "Checked"+car.getId(), Toast.LENGTH_SHORT).show();
            }
            if (!holder.binding.checkFavorite.isChecked()) {
                holder.binding.checkFavorite.setForeground(context.getDrawable(R.drawable.favorite_un_checked_24));
                Toast.makeText(context.getApplicationContext(), "Un Checked"+car.getId(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnLongClickListener(v -> {
            Toast.makeText(context, "Long Press Work", Toast.LENGTH_LONG).show();
            return false;
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ViewCarsActivity.class);
                intent.putExtra("carId",car.getId());

                context.startActivity(intent);
            }
        });



        holder.binding.tvFullNamePost.setText(car.getCarName());
        holder.binding.tvPricePost.setText(car.getPrice()+" $");
        holder.binding.tvTraveledDistance.setText(car.getMileage()+"\\km");
        holder.binding.tvTypeOfGear.setText(car.getTypeOfGear());
        holder.binding.tvPosition.setText(car.getPosition());
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
