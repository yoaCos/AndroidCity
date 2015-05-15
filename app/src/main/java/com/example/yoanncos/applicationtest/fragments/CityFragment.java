package com.example.yoanncos.applicationtest.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yoanncos.applicationtest.R;

/**
 * Created by Yoann.Cos on 04/05/2015.
 */
public class CityFragment extends Fragment {


    public static CityFragment newInstance(int index) {
        CityFragment fragment = new CityFragment();

        Bundle args = new Bundle();
        args.putInt("index", index);
        fragment.setArguments(args);

        return fragment;
    }

    public int getShownIndex(){
        return getArguments().getInt("index", 0);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (container == null){
            Toast.makeText(getActivity(), "C'est null -> OnCreateView",
                    Toast.LENGTH_LONG).show();
            return null;
        }
        Toast.makeText(getActivity(), "CityFragment->OnCreateView",
                Toast.LENGTH_LONG).show();
        View view = inflater.inflate(R.layout.fragment_city, container, false);
        view.findViewById(R.id.imgCity);
        TextView test = (TextView)view.findViewById(R.id.tvCityName);
        test.setText("Putin de mierda");
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

}
