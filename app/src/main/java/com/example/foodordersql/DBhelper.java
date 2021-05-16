package com.example.foodordersql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.foodordersql.modles.OrderModels;

import java.util.ArrayList;

public class DBhelper extends SQLiteOpenHelper {


    final static String DBNAME="mydatabase.db";
    final static  int DBVERSION=1;

    public DBhelper(@Nullable Context context) {
        super(context,DBNAME,null,DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table ordertb " +
                        "(id integer primary key autoincrement," +
                        "name text," +
                        "phone text," +
                        "price int," +
                        "image int," +
                        "Quantity int," +
                        "description text," +
                        "foodname text)"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP table if exists ordertb");
        onCreate(db);
    }
    public boolean inserOrder(String name,String phone,int price,int image,String dsc,String foodName,int quant)
    {
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values=new ContentValues();

        /*
        name=1
        phone =2
        price =3
        image =4
        quant=5
        dsc=6
        foodname=7
         */
        values.put("name",name);
        values.put("phone",phone);
        values.put("price",price);
        values.put("image",image);
        values.put("Quantity",quant);
        values.put("description",dsc);
        values.put("foodname",foodName);
        long id=database.insert("ordertb",null,values);
        if(id<=0)
        {
            return  false;
        }
        else
        {
            return true;
        }

    }
    public ArrayList<OrderModels> getorders()
    {
        ArrayList<OrderModels> ordertb= new ArrayList<>();
        SQLiteDatabase database=this.getWritableDatabase();
        Cursor cursor= database.rawQuery("select id,foodname,image,price from ordertb",null);
        if(cursor.moveToFirst())
        {
            while(cursor.moveToNext())
            {
                OrderModels model =new OrderModels();
                model.setOrdernum(cursor.getInt(0)+"");
                model.setSolditemname(cursor.getString(1));
                model.setOrderimage(cursor.getInt(2));
                model.setPriceorder(cursor.getInt(3)+"");
                ordertb.add(model);



            }
        }
        cursor.close();
        database.close();
        return ordertb;
    }
    public Cursor getorderbyid(int id)
    {

        SQLiteDatabase database=this.getWritableDatabase();
        Cursor cursor= database.rawQuery("select * from ordertb where id = "+ id ,null);

        if(cursor!=null)
        {
            cursor.moveToFirst();
        }

        return cursor;
    }

    // updating order
    public boolean updateOrder(String name,String phone,int price,int image,String dsc,String foodName,int quant,int id)
    {
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values=new ContentValues();
        /*
        name=1
        phone =2
        price =3
        image =4
        quant=5
        dsc=6
        foodname=7
         */
        values.put("name",name);
        values.put("phone",phone);
        values.put("price",price);
        values.put("image",image);
        values.put("Quantity",quant);
        values.put("description",dsc);
        values.put("foodname",foodName);
        long row=database.update("ordertb",values,"id ="+id,null);
        if(row<=0)
        {
            return  false;
        }
        else
        {
            return true;
        }

    }

    public int deleteorder(String id )
    {
        SQLiteDatabase database=this.getWritableDatabase();
        return database.delete("ordertb","id ="+id,null);
    }

}
