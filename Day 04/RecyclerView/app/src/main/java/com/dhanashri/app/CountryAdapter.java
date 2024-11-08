package com.dhanashri.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder>{

    Context context;
    List<String> countrylist;

    public CountryAdapter(Context context, List<String> countrylist) {
        this.context = context;
        this.countrylist = countrylist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.view_holder,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
     holder.countryview.setText(countrylist.get(position));
    }

    @Override
    public int getItemCount() {
        return countrylist.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView countryview;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            countryview=itemView.findViewById(R.id.countryView);
        }


    }
}
