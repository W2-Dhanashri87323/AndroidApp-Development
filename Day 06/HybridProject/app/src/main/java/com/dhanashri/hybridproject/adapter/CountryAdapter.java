package com.dhanashri.hybridproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dhanashri.hybridproject.R;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.MyViewHolder> {

    Context context;
    List<String> countryList;

    public CountryAdapter(Context context, List<String> countryList) {
        this.context = context;
        this.countryList = countryList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.country_vh, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.countryname.setText(countryList.get(position));
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView countryname;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            countryname = itemView.findViewById(R.id.countryname);
        }
    }
}



