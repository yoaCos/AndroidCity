package com.example.yoanncos.applicationtest.Adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yoanncos.applicationtest.Entity.City;
import com.example.yoanncos.applicationtest.R;

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
                final ImageView imgCity = (ImageView)view.findViewById(R.id.iconCity);

                final String cityName = city.getCityName();

                final String cityNameFormat = String.format(res.getString(R.string.name_city)
                        + " " + cityName);
                final String countryName = String.format(res.getString(R.string.name_country)
                        + " " + city.getCountryName());

                switch (position){
                    case 0: imgCity.setImageDrawable(ResourcesCompat.getDrawable(
                            view.getResources(), R.drawable.paros, null));
                        break;
                    case 1: imgCity.setImageDrawable(ResourcesCompat.getDrawable(
                            view.getResources(), R.drawable.madrid, null));
                        break;
                    case 2: imgCity.setImageDrawable(ResourcesCompat.getDrawable(
                            view.getResources(), R.drawable.londres, null));
                        break;
                    case 3: imgCity.setImageDrawable(ResourcesCompat.getDrawable(
                            view.getResources(), R.drawable.berlin, null));
                        break;
                    case 4: imgCity.setImageDrawable(ResourcesCompat.getDrawable(
                            view.getResources(), R.drawable.rome, null));
                        break;
                    case 5: imgCity.setImageDrawable(ResourcesCompat.getDrawable(
                            view.getResources(), R.drawable.lisbonne, null));
                    default: imgCity.setImageDrawable(ResourcesCompat.getDrawable(
                                view.getResources(), R.drawable.abc_btn_rating_star_on_mtrl_alpha, null));
                }

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


