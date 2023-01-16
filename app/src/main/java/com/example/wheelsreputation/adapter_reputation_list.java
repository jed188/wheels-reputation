package com.example.wheelsreputation;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class adapter_reputation_list extends androidx.recyclerview.widget.RecyclerView.Adapter<adapter_reputation_list.MyViewHolder> {

    Context context;

    List<driver_history_class> driver_history_classList;



    public adapter_reputation_list(Context context , List<driver_history_class> driver_history_classList) {
        this.context = context;
        this.driver_history_classList = driver_history_classList;
    }


    @NonNull
    @Override
    public adapter_reputation_list.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent , int viewType) {
        View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.reputation_list_layout,parent,false);
        MyViewHolder holder = new MyViewHolder(rowView);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull adapter_reputation_list.MyViewHolder holder , int position) {

        holder.driver_name_textView2_reputation_list.setText(driver_history_classList.get(position).getDriverName());




        holder.constraintLayout_reputation_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent (context,Find_driver_activity.class);

               // intent.putExtra("driverName",driver_history_classList.get(position).getDriverName());

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return driver_history_classList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView driver_name_textView2_reputation_list;


        ConstraintLayout constraintLayout_reputation_list;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            driver_name_textView2_reputation_list = itemView.findViewById(R.id.driver_name_textView2_reputation_list);

            constraintLayout_reputation_list = itemView.findViewById(R.id.constraintLayout_reputation_list);
        }
    }
}
