package com.example.foodordersql;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.Menu;

import com.example.foodordersql.Adapters.OrderAdapter;
import com.example.foodordersql.databinding.ActivityMainBinding;
import com.example.foodordersql.databinding.ActivityMainorderBinding;
import com.example.foodordersql.modles.OrderModels;

import java.util.ArrayList;

public class Mainorder extends AppCompatActivity {

    ActivityMainorderBinding binding;
    // here declare activity main binding variable for not use find view by id
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainorderBinding.inflate(getLayoutInflater());
        // setContentView(R.layout.activity_main);
        setContentView(binding.getRoot());

        DBhelper db=new DBhelper(this);
        ArrayList<OrderModels> list=db.getorders();


        OrderAdapter adapter=new OrderAdapter(this,list);
        binding.orderrecy.setAdapter(adapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.orderrecy.setLayoutManager(layoutManager);



    }


}