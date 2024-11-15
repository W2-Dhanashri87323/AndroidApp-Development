package com.dhanashri.app.activity;

import android.app.Activity;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dhanashri.app.R;
import com.dhanashri.app.adapter.ProductAdapter;
import com.dhanashri.app.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    List<Product> productList;

    ProductAdapter adaper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productlist);

        recyclerView = findViewById(R.id.recyclerView);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        productList = new ArrayList<>();
        adaper = new ProductAdapter(this, productList, this);
        recyclerView.setAdapter(adaper);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
    }

    public void getAllProducts(){

        ContentResolver resolver = getContentResolver();
        Uri uri= Uri.parse("content:com.dhanashri.");
    }

}
