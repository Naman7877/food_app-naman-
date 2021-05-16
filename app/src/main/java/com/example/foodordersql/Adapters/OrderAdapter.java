package com.example.foodordersql.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodordersql.DBhelper;
import com.example.foodordersql.DetailActivity;
import com.example.foodordersql.R;
import com.example.foodordersql.modles.MainModle;
import com.example.foodordersql.modles.OrderModels;

import java.util.ArrayList;

public class OrderAdapter extends  RecyclerView.Adapter<OrderAdapter.viewHolder>{


    ArrayList<OrderModels> list;
    Context context;


    public OrderAdapter(Context context, ArrayList<OrderModels> list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sampleorder,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  OrderAdapter.viewHolder holder, int position) {
        final OrderModels modle=list.get(position);
        holder.orderImage.setImageResource(modle.getOrderimage());
        holder.soldItemName.setText(modle.getSolditemname());
        holder.priceorder.setText(modle.getPriceorder());
        holder.orderNum.setText(modle.getOrdernum());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, DetailActivity.class);
                intent.putExtra("id",Integer.parseInt(modle.getOrdernum()));
                intent.putExtra("type",2);
                context.startActivity(intent);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                new AlertDialog.Builder(context)
                        .setTitle("Delete iteam ")
                        .setMessage("Are you sure to delete this item ")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                DBhelper dBhelper= new DBhelper(context);
                                if(dBhelper.deleteorder(modle.getOrdernum())>0)
                                {
                                    Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                                }
                                else
                                {
                                    Toast.makeText(context, "NOT Deleted", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {


                            }
                        }).show();


                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView orderImage;
        TextView priceorder,orderNum,soldItemName;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            orderImage=itemView.findViewById(R.id.orderImage);
            priceorder=itemView.findViewById(R.id.priceorder);
            orderNum=itemView.findViewById(R.id.orderNum);
            soldItemName=itemView.findViewById(R.id.solditemname);
        }

    }


}
