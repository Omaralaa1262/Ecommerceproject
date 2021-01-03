package com.example.ecommerceproject;

import android.os.Bundle;
import android.view.View;

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
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);


        List<Categories> productCategoryList = new ArrayList<>();
        productCategoryList.add(new Categories("1", "Trending"));
        productCategoryList.add(new Categories("2", "Most Popular"));
        productCategoryList.add(new Categories("3", "All Body Products"));
        productCategoryList.add(new Categories("4", "Skin Care"));
        productCategoryList.add(new Categories("5", "Hair Care"));
        productCategoryList.add(new Categories("6", "Make Up"));
        productCategoryList.add(new Categories("7", "Fragrance"));

        setProductRecycler(productCategoryList);

        List<Products> productsList = new ArrayList<>();

        //productsList.add(new Products(1, "Japanese Cherry Blossom", "250 ml", "$ 17.00", R.drawable.prod2));
        setProdItemRecycler(productsList);
    }

    private void setProductRecycler(List<Categories> productCategoryList){

        productCatRecycler = findViewById(R.id.cat_recycler);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        productCatRecycler.setLayoutManager(layoutManager);
        productCategoryAdapter = new ProductCategoryAdapter(this, productCategoryList);
        productCatRecycler.setAdapter(productCategoryAdapter);

    }

    private void setProdItemRecycler(List<Products> productsList){

        prodItemRecycler = findViewById(R.id.product_recycler);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        prodItemRecycler.setLayoutManager(layoutManager);
        productAdapter = new ProductAdapter(this, productsList);
        prodItemRecycler.setAdapter(productAdapter);

    }

    // Hi all today we are going to make a online product selling app.
    // basically its a cosmatic selling app.
    // The design is very coll and something new from traditional design.
    // But before getting started lets make sure to subscribe and hit
    // the bell icon to get latest update and notified enerytime i post a new video.
    // so lets get started
    // lets app some font and import some image assets
    // Now we will setup a recyclerview for product category list.
    // now we will ad a model class for our category
    // lets create a adapter class for data model
    // Our adapter class is ready Now we will setup recyclerview
    //now we will add some data to our model class
    // Lets run and see
    // so we have setup category recycler.
    // Now in a same way we create a another recycycler view for products
    // first we make model class then adapter
    // product recycler also setup.
    // now we will setup on clicklistener on products and navigate to details activity.
    // lets do this.
    // before going to details page we need cart button in home page and some layout setup.
    // Now its perfect
    // lets move to the details activity.
    // so lets add some animation in this.
    // So this tutorial has been completed if you love my work plz like share and subscribe
    // and dont forget to comments
    // see you in the next video



}
