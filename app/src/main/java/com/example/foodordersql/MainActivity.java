package com.example.foodordersql;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.foodordersql.Adapters.MainAdapter;
import com.example.foodordersql.databinding.ActivityMainBinding;
import com.example.foodordersql.modles.MainModle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
       // setContentView(R.layout.activity_main);
        setContentView(binding.getRoot());
        //RecyclerView recycler= findViewById(R.id.recycler);
       // getSupportActionBar().hide();


        ArrayList<MainModle> list=new ArrayList<>();
        list.add(new MainModle(R.drawable.burger,"burger","2","veg"));
        list.add(new MainModle(R.drawable.pizza,"Pizza","10","veg"));
        list.add(new MainModle(R.drawable.franchfrieds,"Franch Frieds","2","veg"));
        list.add(new MainModle(R.drawable.vegrol,"Veg Rol","4","veg"));
        list.add(new MainModle(R.drawable.dabeli,"Dabeli","3","veg"));
        list.add(new MainModle(R.drawable.samosa,"Samosa","1","veg"));
        list.add(new MainModle(R.drawable.manchurin,"Machurin","5","veg"));
        list.add(new MainModle(R.drawable.nodle,"Nodles","6","veg with all vegtables"));
        list.add(new MainModle(R.drawable.burger,"burger","15","veg"));
        list.add(new MainModle(R.drawable.burger,"burger","15","veg"));
        list.add(new MainModle(R.drawable.burger,"burger","15","veg"));
        list.add(new MainModle(R.drawable.burger,"burger","15","veg"));


        // here create main adapter
        MainAdapter adapter=new MainAdapter(list,this);

        // if we use view binding concept then there is no need to (findviewbyid)
        // binding automatic fetch the root


        binding.recycler.setAdapter(adapter);
        // recycler.setAdapter(adapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.recycler.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.order:
                startActivity(new Intent(MainActivity.this,Mainorder.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}