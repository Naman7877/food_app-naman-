package com.example.foodordersql.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodordersql.DetailActivity;
import com.example.foodordersql.R;
import com.example.foodordersql.modles.MainModle;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewholder>  {


    ArrayList<MainModle> list ;
    Context context;
    public MainAdapter(ArrayList<MainModle> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_mainfood,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        final  MainModle modle=list.get(position);
        holder.image.setImageResource(modle.getImage());
        holder.name.setText(modle.getName());
        holder.price.setText(modle.getPrice());
        holder.dsic.setText(modle.getDsic());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, DetailActivity.class);

                intent.putExtra("image",modle.getImage());
                intent.putExtra("name",modle.getName());
                intent.putExtra("price",modle.getPrice());
                intent.putExtra("dsci",modle.getDsic());
                intent.putExtra("type",1);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder
    {

        ImageView image;
        TextView name,price,dsic;

        public viewholder(@NonNull View itemView) {

            super(itemView);

            image=itemView.findViewById(R.id.image);
            name=itemView.findViewById(R.id.name);
            price=itemView.findViewById(R.id.price);
            dsic=itemView.findViewById(R.id.disc);
        }
    }

}
