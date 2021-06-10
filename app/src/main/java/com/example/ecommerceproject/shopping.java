package com.example.ecommerceproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapter.CartListAdapter;
import adapter.ProductAdapter;
import adapter.ProductCategoryAdapter;
import model.*;

public class shopping extends AppCompatActivity {
    RecyclerView productCartRecycler;
    CartListAdapter productCartAdapter;
    List<shopping_cart> cartproduct = new ArrayList<>();

    Cursor shopping_data;
    Cursor Total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
        String User_Name=getIntent().getStringExtra("User_Name");
        ImageView back=(ImageView)findViewById(R.id.backtomain);


        Ecommercehelper Helper=new Ecommercehelper(this);
        shopping_data=Helper.getshoppingcart(User_Name);
        if(shopping_data.moveToFirst()){
            while (!shopping_data.isAfterLast()){
                cartproduct.add(new shopping_cart(shopping_data.getString(0),shopping_data.getString(1),shopping_data.getString(2),shopping_data.getString(3),shopping_data.getString(4)));
                shopping_data.moveToNext();

            }
        }
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(shopping.this, MainActivity.class);
                i.putExtra("User_Name",User_Name);
                startActivity(i);

            }
        });
        setProdItemRecyclercart(cartproduct,User_Name);
        Button placeorder=(Button)findViewById(R.id.btn_placeorder);
        TextView totalTXT=(TextView)findViewById(R.id.Total);
        int Totalint=0;
        Total=Helper.gettotal(User_Name);
        if(Total.moveToFirst()){
            while (!Total.isAfterLast()){
                Totalint=Total.getInt(0);
                Total.moveToNext();
            }
        }
        totalTXT.setText(Integer.toString(Totalint));

        placeorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Order Placed successfully!", Toast.LENGTH_LONG).show();
                Intent i=new Intent(shopping.this, MainActivity.class);
                i.putExtra("User_Name",User_Name);
                startActivity(i);

            }
        });

    }
    private void setProdItemRecyclercart(List< shopping_cart > cartlist,String username){

        productCartRecycler = findViewById(R.id.recycler_cart);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        productCartRecycler.setLayoutManager(layoutManager);
        productCartAdapter = new CartListAdapter(this, cartlist,username);
        productCartRecycler.setAdapter(productCartAdapter);

    }
}