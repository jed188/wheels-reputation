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


public class MyAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<driver_history_class> driver_history_classList;

    Context context;

    public MyAdapter(List<driver_history_class> driver_history_classList , Context context) {
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

        holder.available_textView_reputation_list.setText(driver_history_classList.get(position).getAvailability());

        holder.history_resume.setText(driver_history_classList.get(position).getDescription());

        holder.score_textView_reputation_list.setText(String.valueOf(driver_history_classList.get(position).getRating()));

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context,detailed_history.class);

                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return driver_history_classList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView history_resume;

        TextView available_textView_reputation_list;

        TextView score_textView_reputation_list;

        ConstraintLayout constraintLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            history_resume = itemView.findViewById(R.id.history_resume);

            available_textView_reputation_list = itemView.findViewById(R.id.available_textView_reputatio_list);

            score_textView_reputation_list = itemView.findViewById(R.id.score_textView_reputation_list);

            constraintLayout = itemView.findViewById(R.id.history_constraintLayout);

        }
    }
}


