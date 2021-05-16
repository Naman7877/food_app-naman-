package com.example.foodordersql;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.foodordersql.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_detail);

        binding=ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBhelper helper = new DBhelper(this);
        if(getIntent().getIntExtra("type",0)==1)
        {


            final int image = getIntent().getIntExtra("image", 0);
            final String name = getIntent().getStringExtra("name");
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            final String dsci = getIntent().getStringExtra("dsci");

            binding.detailimage.setImageResource(image);
            binding.detailprice.setText(String.format("%d", price));
            binding.foody.setText(name);
            binding.des.setText(dsci);


            binding.insert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    boolean Inserted = helper.inserOrder(
                            binding.nameuse.getText().toString(),
                            binding.phone.getText().toString(),
                            price,
                            image,
                            name,
                            dsci,
                            Integer.parseInt(binding.quant.getText().toString())

                    );
                    if (Inserted) {
                        Toast.makeText(DetailActivity.this, "Saved ", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(DetailActivity.this, "Failed ", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
        else {
            int id =getIntent().getIntExtra("id",0);
            Cursor cursor= helper.getorderbyid(id);
            int image=cursor.getInt(4);
            binding.detailimage.setImageResource(image); // image index is 3 db helper
            binding.detailprice.setText(String.format("%d", cursor.getInt(3)));
            binding.foody.setText(cursor.getString(6)); //1
            binding.des.setText(cursor.getString(5));
            binding.nameuse.setText(cursor.getString(1));
            binding.phone.setText(cursor.getString(2));
            binding.insert.setText("update now");
            binding.insert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   boolean isupdated= helper.updateOrder(
                            binding.nameuse.getText().toString(),
                            binding.phone.getText().toString(),
                            Integer.parseInt(binding.detailprice.getText().toString()),
                            image,
                            binding.des.getText().toString(),
                            binding.foody.getText().toString(),
                            1,
                            id
                    );
                   if(isupdated)
                   {
                       Toast.makeText(DetailActivity.this, "updated", Toast.LENGTH_SHORT).show();
                   }
                   else
                   {
                       Toast.makeText(DetailActivity.this, "Faild", Toast.LENGTH_SHORT).show();
                   }

                }
            });


        }
    }
}