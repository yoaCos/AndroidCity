package com.example.yoanncos.applicationtest.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yoanncos.applicationtest.Adapter.CityAdapter;
import com.example.yoanncos.applicationtest.CityActivity;
import com.example.yoanncos.applicationtest.Entity.City;
import com.example.yoanncos.applicationtest.R;

import java.util.ArrayList;

/**
 * Created by Yoann.Cos on 06/05/2015.
 */
public class ListFragment extends android.app.ListFragment {

    Boolean mDualPane;
    int mCurCheckPosition = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_liste_city, container, false);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final ArrayList<City> arrayListCity = new ArrayList<>();
        City.initList(arrayListCity);
        final CityAdapter cityAdapter = new CityAdapter(getActivity(), R.layout.row_city, arrayListCity);
        getListView().setAdapter(cityAdapter);

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                CityFragment cityFragment = (CityFragment)getFragmentManager().findFragmentById(R.id.frameDetails);

                final TextView tvCity = (TextView)view.findViewById(R.id.tvCity);
                final TextView tvCountry = (TextView)view.findViewById(R.id.tvCountry);

                String s = (String)tvCity.getText();
                String st = (String)tvCountry.getText();

                if (cityFragment != null && cityFragment.isVisible()){
                    cityFragment.setText(s, st);

                }else {
                    Intent intent = new Intent(getActivity(), CityActivity.class);
                    intent.putExtra("name", s);
                    intent.putExtra("country", st);
                    startActivity(intent);
                }

            }
        });
    }
}



