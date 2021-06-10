package com.example.ecommerceproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

import adapter.ProductAdapter;
import adapter.ProductCategoryAdapter;
import model.Categories;
import model.Products;

public class MainActivity extends AppCompatActivity {

    ProductCategoryAdapter productCategoryAdapter;
    RecyclerView productCatRecycler, prodItemRecycler;
    ProductAdapter productAdapter;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

    }}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView logout=(TextView)findViewById(R.id.logouttxt);

        Ecommercehelper Helper=new Ecommercehelper(this);
        TextView username=(TextView)findViewById(R.id.username);
        Button showcartmainactivity =(Button)findViewById(R.id.shoppingcart_mainactivity);
        String User_Name=getIntent().getStringExtra("User_Name");

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        username.setText(User_Name);
        List<Categories> cat = new ArrayList<>();
        List<Products> productsList = new ArrayList<>();
        Cursor cat_data=Helper.getCategories();
        Cursor product_data=Helper.getproducts();
        ImageView searchibtn=(ImageView)findViewById(R.id.SearchButton_image);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,sighnin.class);
                i.putExtra("flage","1");
                startActivity(i);

            }
        });
        searchibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,search.class);
                startActivity(i);

            }
        });
        if(cat_data.moveToFirst()){
            while (!cat_data.isAfterLast()){
                cat.add(new Categories(cat_data.getString(0),cat_data.getString(1)));
                cat_data.moveToNext();
            }
        }
        if(product_data.moveToFirst()){
            while (!product_data.isAfterLast()){
                productsList.add(new Products(product_data.getInt(0),product_data.getString(1),product_data.getString(2),product_data.getString(3),product_data.getInt(4),product_data.getInt(5)));
                product_data.moveToNext();
            }
        }
        setProductRecycler(cat);
        setProdItemRecycler(productsList,User_Name);


        showcartmainactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,shopping.class);
                i.putExtra("User_Name",User_Name);
                startActivity(i);

            }
        });
    }

    private void setProductRecycler(List<Categories> productCategoryList){

        productCatRecycler = findViewById(R.id.cat_recycler);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        productCatRecycler.setLayoutManager(layoutManager);
        productCategoryAdapter = new ProductCategoryAdapter(this, productCategoryList);
        productCatRecycler.setAdapter(productCategoryAdapter);

    }

    private void setProdItemRecycler(List<Products> productsList,String username){

        prodItemRecycler = findViewById(R.id.product_recycler);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        prodItemRecycler.setLayoutManager(layoutManager);
        productAdapter = new ProductAdapter(this, productsList,username);
        prodItemRecycler.setAdapter(productAdapter);

    }
}
