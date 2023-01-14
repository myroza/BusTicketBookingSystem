package com.example.busticketbookingsystem;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private ArrayList name_id, source_id, destination_id,start_id,Arrive_id,Fare_id,Date_id;


    public MyAdapter(Context context, ArrayList name_id, ArrayList source_id, ArrayList destination_id,ArrayList start_id,ArrayList Arrive_id,ArrayList Fare_id,ArrayList Date_id) {
        this.context = context;
        this.name_id = name_id;
        this.source_id = source_id;
        this.destination_id = destination_id;
        this.start_id = start_id;
        this.Arrive_id = Arrive_id;
        this.Fare_id = Fare_id;
        this.Date_id = Date_id;



    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry, parent, false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name_id.setText(String.valueOf(name_id.get(position)));
        holder.source_id.setText(String.valueOf(source_id.get(position)));
        holder.destination_id.setText(String.valueOf(destination_id.get(position)));
        holder.start_id.setText(String.valueOf(start_id.get(position)));
        holder.Arrive_id.setText(String.valueOf(Arrive_id.get(position)));
        holder.Fare_id.setText(String.valueOf(Fare_id.get(position)));
        holder.Date_id.setText(String.valueOf(Date_id.get(position)));



    }

    @Override
    public int getItemCount() {
        return name_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name_id, source_id, destination_id,start_id,Arrive_id,Date_id,Fare_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name_id = itemView.findViewById(R.id.textname);
            source_id = itemView.findViewById(R.id.textsource);
            destination_id = itemView.findViewById(R.id.textdestination);
            start_id = itemView.findViewById(R.id.textstart);
            Arrive_id= itemView.findViewById(R.id.textarrive);
            Fare_id = itemView.findViewById(R.id.textFare);
            Date_id= itemView.findViewById(R.id.textdate);




        }


    }

}