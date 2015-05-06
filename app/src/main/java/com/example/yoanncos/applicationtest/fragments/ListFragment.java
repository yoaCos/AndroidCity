package com.example.yoanncos.applicationtest.fragments;

import android.os.Bundle;

import com.example.yoanncos.applicationtest.Adapter.CityAdapter;
import com.example.yoanncos.applicationtest.Entity.City;
import com.example.yoanncos.applicationtest.R;

import java.util.ArrayList;

/**
 * Created by Yoann.Cos on 06/05/2015.
 */
public class ListFragment extends android.app.ListFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final ArrayList<City> arrayListCity = new ArrayList<>();
        City.initList(arrayListCity);
        final CityAdapter cityAdapter = new CityAdapter(getActivity(), R.layout.row_city,
                arrayListCity);
        arrayListCity.setAdapter(cityAdapter);

    }


}
