package com.example.yoanncos.applicationtest.fragments;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

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
        outState.putInt("curChoice", mCurCheckPosition);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        showDetails(position);
    }

    private void showDetails(int index) {
        mCurCheckPosition = index;

        if (mDualPane){
            getListView().setItemChecked(index, true);

            CityFragment cityFragment = (CityFragment)getFragmentManager()
                    .findFragmentById(R.id.frameDetails);

            if (cityFragment == null){

                cityFragment = CityFragment.newInstance(index);
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                if (index == 0){
                    ft.replace(R.id.frameDetails, cityFragment);
                    Toast.makeText(getActivity(), "index == 0",
                            Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getActivity(), "index != 0",
                            Toast.LENGTH_LONG).show();
                }

                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();

            }else {
                Intent intent = new Intent();
                intent.setClass(getActivity(), CityActivity.class);
                intent.putExtra("index", index);
                startActivity(intent);
            }
        }
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final ArrayList<City> arrayListCity = new ArrayList<>();
        City.initList(arrayListCity);
        final CityAdapter cityAdapter = new CityAdapter(getActivity(), R.layout.row_city, arrayListCity);
        getListView().setAdapter(cityAdapter);


        View detailsFrame = getActivity().findViewById(R.id.frameDetails);
        mDualPane = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

        if (savedInstanceState != null){
            mCurCheckPosition = savedInstanceState.getInt("curChoice", 0);
        }

        if (mDualPane){
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            showDetails(mCurCheckPosition);
        }

    }
}



