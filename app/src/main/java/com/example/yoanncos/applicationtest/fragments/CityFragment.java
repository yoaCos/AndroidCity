package com.example.yoanncos.applicationtest.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yoanncos.applicationtest.R;

/**
 * Created by Yoann.Cos on 04/05/2015.
 */
public class CityFragment extends Fragment {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


 //  public static CityFragment newInstance(Bundle bundle){
 //      CityFragment cityFragment = new CityFragment();

 //  }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_city, container, false);
        return view;
    }

    public void setText(String cityName, String countryName){
        TextView tvCityName = (TextView)getView().findViewById(R.id.tvCityName);
        TextView tvCountryName = (TextView)getView().findViewById(R.id.tvCountryName);
        tvCityName.setText(cityName);
        tvCountryName.setText(countryName);
    }

}
