package com.example.ecommerceproject;

import android.app.Application;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import model.*;

import androidx.appcompat.app.AppCompatActivity;

public class Productdetails extends AppCompatActivity {
    String QYtafteredit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QYtafteredit="1";
        setContentView(R.layout.activity_productdetails);
        String Product_Name=getIntent().getStringExtra("product name");
        String Product_Price=getIntent().getStringExtra("product price");
        String product_Quantity=getIntent().getStringExtra("product Quantity");
        String User_Name=getIntent().getStringExtra("User_Name");

        int Quantity2=Integer.parseInt(product_Quantity);
        //String Product_Quantity=getIntent().getStringExtra("product Quantity");
        TextView product_Name_text=(TextView)findViewById(R.id.Productdetails_Name);
        product_Name_text.setText(Product_Name);
        TextView product_price_text=(TextView)findViewById(R.id.ProductDetails_Price);
        product_price_text.setText(Product_Price);

        ImageView plusQt=(ImageView) findViewById(R.id.imagebuttonadd);
        TextView productQUT=(TextView)findViewById(R.id.textProductQuantity);
        ImageView minQUT=(ImageView) findViewById(R.id.imagebuttonsub);
        Button AddToCart =(Button)findViewById(R.id.addtocartbutton);


        ImageView showcartproductdetails=(ImageView) findViewById(R.id.shoppingcart_productDetailes);

        AddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shopping_cart shoppingcartobject=new shopping_cart(User_Name,Product_Name,QYtafteredit,"1",Product_Price);
                final Ecommercehelper helper=new Ecommercehelper(Productdetails.this);
                helper.Insert_ShoppingCart(shoppingcartobject);
                Toast.makeText(getApplicationContext(), "Added Successfully", Toast.LENGTH_LONG).show();
                Intent i=new Intent(Productdetails.this,MainActivity.class);
                i.putExtra("User_Name",User_Name);
                startActivity(i);

            }
        });

        showcartproductdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Productdetails.this,shopping.class);
                i.putExtra("User_Name",User_Name);
                startActivity(i);

            }
        });
        plusQt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity=Integer.parseInt(productQUT.getText().toString());
                if(quantity++<Quantity2){
                    productQUT.setText(Integer.toString(quantity++));
                }
                else{
                    Toast.makeText(getApplicationContext(),"Not Available Quantity",Toast.LENGTH_LONG).show();
                }
                QYtafteredit=Integer.toString(quantity);
            }
        });
        minQUT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity=Integer.parseInt(productQUT.getText().toString());
                if(quantity-->0){
                    productQUT.setText(Integer.toString(quantity--));
                }
                else{
                    Toast.makeText(getApplicationContext(),"Not Available",Toast.LENGTH_LONG).show();
                }
                QYtafteredit=Integer.toString(quantity);
            }
        });
        ImageView backimage=(ImageView)findViewById(R.id.imageViewback);
        backimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Productdetails.this,MainActivity.class);
                i.putExtra("User_Name",User_Name);
                startActivity(i);

            }
        });




    }
}
