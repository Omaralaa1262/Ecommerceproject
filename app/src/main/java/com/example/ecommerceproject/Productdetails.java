package com.example.ecommerceproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Productdetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productdetails);
        String Product_Name=getIntent().getStringExtra("product name");
        String Product_Price=getIntent().getStringExtra("product price");
        String Product_Quantity=getIntent().getStringExtra("product Quantity");


    }
}
