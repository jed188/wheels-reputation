package com.example.wheelsreputation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SparesAdapter extends RecyclerView.Adapter<SparesAdapter.MyViewHolder> {

    List<spare_parts_class> spare_parts_class1;
    Context context;

    public SparesAdapter(List<spare_parts_class> spare_parts_class1 , Context context) {
        this.spare_parts_class1 = spare_parts_class1;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent , int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.spare_parts_layout,parent,false);

        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder , int position) {

        holder.description.setText(spare_parts_class1.get(position).getDescription());
        holder.size.setText(spare_parts_class1.get(position).getSize());
        holder.make.setText(spare_parts_class1.get(position).getMake());
        holder.model.setText(spare_parts_class1.get(position).getModel());
        holder.picture.setImageResource(spare_parts_class1.get(position).getPicture());

    }

    @Override
    public int getItemCount() {
        return spare_parts_class1.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView description;
        TextView size;
        TextView make;
        TextView model;
        ImageView picture;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            description = itemView.findViewById(R.id.textView19);
            size = itemView.findViewById(R.id.textView20);
            make = itemView.findViewById(R.id.textView21);
            model =  itemView.findViewById(R.id.textView22);
            picture = itemView.findViewById(R.id.imageView4);

        }
    }
}
