package com.ocem.getwheels.adapter;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ocem.getwheels.DescriptionActivity;
import com.ocem.getwheels.R;
import com.ocem.getwheels.model.CarListModel;
import com.ocem.getwheels.sharedpreference.Constant;
import com.ocem.getwheels.sharedpreference.SharedPrefsHelper;

import java.util.List;

public class CarListAdapter extends RecyclerView.Adapter<CarListAdapter.myViewHolder> {

    List<CarListModel> list;
    Context context;
    BookingAdapter.ItemClickListener itemClickListener;
    String showPlace;
    String showDate;
    String image;
    SharedPrefsHelper sharedPrefsHelper;

    public CarListAdapter(List<CarListModel> list, Context context, String showPlace, String showDate) {
        this.list = list;
        this.context = context;
        this.showPlace = showPlace;
        this.showDate = showDate;
    }


    @Override
    public CarListAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_list, parent, false);
        sharedPrefsHelper = SharedPrefsHelper.getInstance(context);
        return new myViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(@NonNull CarListAdapter.myViewHolder holder, @SuppressLint("RecyclerView") int position) {

        image = list.get(position).getImage();
        Log.i(TAG, "onBindViewHolder: " +list.get(position).getImage());
//        Glide.with(context).load(image).error(R.drawable.no_image).into(holder.ivImage);
        Glide.with(context).load("http://127.0.0.1:8000/storage/vehicle/1664375601_mateusz-waclawek-t2b2svMf8ek-unsplash.jpg")
                .error(R.drawable.no_image)
                .into(holder.ivImage);

        holder.tvname.setText(list.get(position).getName());
        holder.tvseat.setText(list.get(position).getSeat());
        holder.tvprice.setText(list.get(position).getPrice());

        holder.btbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Bundle bundle = new Bundle();
//                bundle.putString("showPlace", showPlace);
//                bundle.putString("showDate", showDate);
//                Intent intent = new Intent(context, DescriptionActivity.class);
//                intent.putExtras(bundle);
//                context.startActivity(intent);
                context.startActivity(new Intent(context,DescriptionActivity.class));
                sharedPrefsHelper.saveValue(Constant.SELECTED_CAR_PRICE,list.get(position).getPrice());
                sharedPrefsHelper.saveValue(Constant.SELECTED_CAR_NAME,list.get(position).getName());
                sharedPrefsHelper.saveValue(Constant.SELECTED_CAR_IMAGE,list.get(position).getImage());
//            Intent intent = new Intent(context  , DescriptionActivity.class);
//            context.startActivity(intent);
//                Toast.makeText(context, "Clicked on View Details", Toast.LENGTH_SHORT).show();
//                itemClickListener.clickOnItem();
            }
        });
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImage;
        TextView tvname, tvdetails, tvseat, tvprice;
        Button btbook;

        public myViewHolder(View itemView) {
            super(itemView);

            ivImage = itemView.findViewById(R.id.ivImage);
            tvname = itemView.findViewById(R.id.tvname);
            tvdetails = itemView.findViewById(R.id.tvdetails);
            tvseat = itemView.findViewById(R.id.tvseat);
            tvprice = itemView.findViewById(R.id.tvprice);
            btbook = itemView.findViewById(R.id.btbook);
        }
    }
}