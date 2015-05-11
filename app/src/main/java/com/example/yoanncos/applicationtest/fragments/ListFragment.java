package com.example.yoanncos.applicationtest.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

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

        ArrayList<City> arrayListCity = new ArrayList<>();
        City.initList(arrayListCity);
        final CityAdapter cityAdapter = new CityAdapter(getActivity(), R.layout.row_city,
                arrayListCity);

        ListView listView = (ListView) getView().findViewById(R.id.list1);
        listView.setAdapter(cityAdapter);


    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String item = (String) getListAdapter().getItem(position);
        CityFragment fragment = (CityFragment)getFragmentManager().findFragmentById(R.id.cityDetailFragment);

        if (fragment != null && fragment.isInLayout()){
            fragment.setText(item);
        }else {
        }
    }
}
