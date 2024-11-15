package com.dhanashri.app.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dhanashri.app.entity.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    Context context;
    List<Product> productList;

    public interface DeleteListner{
        void deleteProduct(Product product);
    }
    private DeleteListner deleteListner;

    public ProductAdapter(Context context, List<Product> productList, DeleteListner deleteListner) {
        this.context = context;
        this.productList = productList;
        this.deleteListner = deleteListner;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
