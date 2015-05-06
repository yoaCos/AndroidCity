package com.example.yoanncos.applicationtest.Adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.yoanncos.applicationtest.Entity.Mayor;
import com.example.yoanncos.applicationtest.R;

import java.util.ArrayList;

/**
 * Created by Yoann.Cos on 06/05/2015.
 */
public class MayorAdapter extends ArrayAdapter<Mayor> {

    private ArrayList<Mayor> arrayListMayor;
    private Context context;
    private int viewRes;
    private Resources res;


    public MayorAdapter(Context context, int textViewResourceId, ArrayList<Mayor> mayor) {
        super(context, textViewResourceId, mayor);
        this.arrayListMayor = mayor;
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

            final Mayor mayor = arrayListMayor.get(position);

            if (arrayListMayor != null){
                final TextView tvName = (TextView)view.findViewById(R.id.tvMayorName);
                final TextView tvCity = (TextView)view.findViewById(R.id.tvMayorCity);
                final TextView tvAge = (TextView)view.findViewById(R.id.tvMayorAge);
                final TextView tvXP = (TextView)view.findViewById(R.id.tvMayorXp);

                final String mayorInfos = String.format(res.getString(R.string.name) + res.getString(R.string.mayor_info),
                        mayor.getName(), mayor.getAge());
                final String cityInfos = String.format(res.getString(R.string.mayor_of_til),
                        mayor.getCity(), mayor.getExperience());

                tvName.setText(mayorInfos);
                tvCity.setText(cityInfos);
            }
        }  return view;
    }

    @Override
    public int getCount() {
        return arrayListMayor.size();
    }
}

