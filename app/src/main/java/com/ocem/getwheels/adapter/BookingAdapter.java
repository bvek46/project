package com.ocem.getwheels.adapter;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ocem.getwheels.DescriptionActivity;
import com.ocem.getwheels.MainActivity;
import com.ocem.getwheels.R;
import com.ocem.getwheels.booking_detailsActivity;
import com.ocem.getwheels.model.Booking;

import java.util.List;

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.myViewHolder> {


    List<Booking> list;
    Context context;
    ItemClickListener itemClickListener;
    String showPlace;
    String showDate;

    public BookingAdapter(List<Booking> list, Context context, String showPlace, String showDate) {
        this.list = list;
        this.context = context;
        this.showPlace = showPlace;
        this.showDate = showDate;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.booking_list_item,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.tvTitle.setText(list.get(position).getName());
        holder.tvPayMethodCod.setText(list.get(position).getPaymentMethod());
        holder.tvPaidStatus.setText(list.get(position).getPaymentStatus());
        holder.tvAmt.setText(String.valueOf(list.get(position).getBillingAmt()));
        holder.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("showPlace", showPlace);
                bundle.putString("showDate", showDate);
                Intent intent = new Intent(context, booking_detailsActivity.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
                Log.i(TAG, "onClick: value at recycler view: " +showPlace+ " "+showDate);

//            Intent intent = new Intent(context  , DescriptionActivity.class);
//            context.startActivity(intent);
//                Toast.makeText(context, "Clicked on View Details", Toast.LENGTH_SHORT).show();
//                itemClickListener.clickOnItem();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle,tvPayMethodCod,tvPaidStatus,tvAmt;
        Button button1;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvPayMethodCod = itemView.findViewById(R.id.tvPayMethodCod);
            tvPaidStatus = itemView.findViewById(R.id.tvPaidStatus);
            tvAmt = itemView.findViewById(R.id.tvAmt);
            button1 = itemView.findViewById(R.id.button1);
        }}

    public interface ItemClickListener {
        void clickOnItem();
    }
}
