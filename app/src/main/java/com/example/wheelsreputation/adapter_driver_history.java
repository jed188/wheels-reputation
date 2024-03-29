package com.example.wheelsreputation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


public class adapter_driver_history extends androidx.recyclerview.widget.RecyclerView.Adapter<adapter_driver_history.MyViewHolder> {

    List<driver_history_class> driver_history_classList;

    Context context;

    public adapter_driver_history(List<driver_history_class> driver_history_classList , Context context) {
        this.driver_history_classList = driver_history_classList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent , int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_layout,parent,false);

        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder , int position) {

        holder.history_resume.setText(driver_history_classList.get(position).getDescription());


    }

    @Override
    public int getItemCount() {
        return driver_history_classList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView history_resume;

        ConstraintLayout constraintLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            history_resume = itemView.findViewById(R.id.history_resume);

            constraintLayout = itemView.findViewById(R.id.history_constraintLayout);

        }
    }
}


