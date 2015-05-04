package com.example.yoanncos.applicationtest;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Yoann.Cos on 04/05/2015.
 */
public class CityAdapter extends ArrayAdapter<City> {

    private ArrayList<City> arrayCityList;
    private Context context;

    private int viewRes;
    private Resources res;


    public CityAdapter(Context context, int textViewResourceId, ArrayList<City> city) {
        super(context, textViewResourceId, city);
        this.arrayCityList = city;
        this.context = context;
        this.viewRes = textViewResourceId;
        this.res = context.getResources();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null){
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(viewRes, parent, false);
            final City city = arrayCityList.get(position);
            if (arrayCityList != null){
                final TextView tvCity = (TextView)view.findViewById(R.id.tvCity);
                final TextView tvCountry = (TextView)view.findViewById(R.id.tvCountry);

                final String cityName = String.format(res.getString(R.string.name_city)
                        + " " + city.getCityName());
                final String countryName = String.format(res.getString(R.string.name_country)
                        + " " + city.getCountryName());

                tvCity.setText(cityName);
                tvCountry.setText(countryName);
            }
        }  return view;
    }

    @Override
    public int getCount() {
        return arrayCityList.size();
    }
}
