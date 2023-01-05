package com.example.wheelsreputation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter_Stolen_bike extends RecyclerView.Adapter<Adapter_Stolen_bike.MyViewHolder>{

    List<stolen_bike_class> stolen_bike_classList;

    Context context;

    public Adapter_Stolen_bike(List<stolen_bike_class> stolen_bike_classList , Context context) {
        this.stolen_bike_classList = stolen_bike_classList;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter_Stolen_bike.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent , int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stolen_bike_layout,parent,false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_Stolen_bike.MyViewHolder holder , int position) {

        holder.make.setText(stolen_bike_classList.get(position).getMake());
        holder.model.setText(stolen_bike_classList.get(position).getModel());
        holder.OwnerName.setText(stolen_bike_classList.get(position).getOwnerName());
        holder.cellphone.setText(stolen_bike_classList.get(position).getCellphone());
        holder.driverName.setText(stolen_bike_classList.get(position).getDriverName());
        holder.plateNumber.setText(stolen_bike_classList.get(position).getPlateNumber());
        holder.note.setText(stolen_bike_classList.get(position).getNote());

    }

    @Override
    public int getItemCount() {
        return stolen_bike_classList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView vehiculeType;
        TextView make;
        TextView model;
        TextView OwnerName;
        TextView cellphone;
        TextView driverName;
        TextView plateNumber;
        TextView note;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            vehiculeType = itemView.findViewById(R.id.vehicule_type_value_stolen_bike_textView3_add_stolen_bike);
            make = itemView.findViewById(R.id.vehicule_make_value_textView14_add_stolen_bike);
            model = itemView.findViewById(R.id.vehicule_type_value_textView15_add_stolen_bike);
            OwnerName = itemView.findViewById(R.id.owner_name_value_textView_add_stolen_bike);
            cellphone = itemView.findViewById(R.id.contact_number_value_textView_add_stolen_bike);
            driverName = itemView.findViewById(R.id.driver_name_value_stolen_bike_textView2_add_stolen_bike);
            plateNumber = itemView.findViewById(R.id.plate_number_value_stolen_bike_textView_add_stolen_bike);
            note = itemView.findViewById(R.id.editTextTextMultiLine_add_stolen_bike);
        }
    }
}
