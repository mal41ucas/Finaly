package com.example.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Model.Car;
import com.example.Model.ShowCar;
import com.example.Screen_Home.MyCarsActivity;
import com.example.Screen_Home.ProfileActivity;
import com.example.Screen_Home.ViewCarsActivity;
import com.example.projectcar.R;
import com.example.projectcar.databinding.ModelRcHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class ShowCarAdapter extends RecyclerView.Adapter<ShowCarAdapter.viewHolder> {

    Context context;
    List<ShowCar> arrayList;

    public ShowCarAdapter(Context context, List<ShowCar> arrayList) {
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
        holder.binding.imgViewCar.setImageResource(R.drawable.audi);

        holder.binding.checkFavorite.setOnClickListener(v -> {
            if (holder.binding.checkFavorite.isChecked()) {
                holder.binding.checkFavorite.setForeground(context.getDrawable(R.drawable.favorite_checked_24));
            }
            if (!holder.binding.checkFavorite.isChecked()) {
                holder.binding.checkFavorite.setForeground(context.getDrawable(R.drawable.favorite_un_checked_24));
            }
        });

        holder.itemView.setOnLongClickListener(v -> {
            Toast.makeText(context, "Long Press Work", Toast.LENGTH_LONG).show();
            return false;
        });

        holder.binding.imagePerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, MyCarsActivity.class));
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap imageBitmap = ((BitmapDrawable) holder.binding.imgViewCar.getDrawable()).getBitmap();
                Intent intent = new Intent(context, ViewCarsActivity.class);
                intent.putExtra("carName", showCar.getCarName());
                intent.putExtra("img", showCar.getImg());
                intent.putExtra("carPrice", showCar.getCarPrice());
                intent.putExtra("desc", showCar.getDescription());
                intent.putExtra("travel", showCar.getCarTraveledDistance());
                intent.putExtra("map", showCar.getLocation());
                intent.putExtra("gear", showCar.getTypeGear());
                context.startActivity(intent);
            }
        });

        holder.binding.imgViewCar.setImageResource(showCar.getImg());
        holder.binding.imagePerson.setImageResource(showCar.getImgPerson());
        holder.binding.tvFullNamePost.setText(showCar.getCarName());
        holder.binding.tvPricePost.setText(showCar.getCarPrice() + " $");
        holder.binding.tvTraveledDistance.setText(showCar.getCarTraveledDistance() + "\\km");
        holder.binding.tvTypeOfGear.setText(showCar.getTypeGear());
        holder.binding.tvLocation.setText(showCar.getLocation());
        holder.binding.textPerson.setText(showCar.getNamePerson());
        holder.binding.textDescription.setText(showCar.getDescription());
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
