package com.dhanashri.hybridproject.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dhanashri.hybridproject.R;
import com.dhanashri.hybridproject.adapter.CountryAdapter;

import java.util.ArrayList;
import java.util.List;


public class CountryFragment extends Fragment {

    RecyclerView recyclerView;

    List<String> countryList;

    CountryAdapter countryAdapter;


    public CountryFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        countryList = new ArrayList<>();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_country, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        countryList.add("India");
        countryList.add("United States");
        countryList.add("United Kingdom");
        countryList.add("Canada");
        countryList.add("Australia");
        countryList.add("Germany");
        countryList.add("France");
        countryList.add("Japan");
        countryList.add("China");
        countryList.add("Brazil");

        recyclerView=view.findViewById(R.id.country_recycle);
        countryAdapter=new CountryAdapter(getContext(),countryList);
        recyclerView.setAdapter(countryAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
    }
}



