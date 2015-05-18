package com.example.yoanncos.applicationtest;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by yoann_000 on 11/05/2015.
 */
public class CityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            String s = bundle.getString("name");
            String st = bundle.getString("country");
            TextView tvCityName = (TextView)findViewById(R.id.tvCityName);
            TextView tvCountryName = (TextView)findViewById(R.id.tvCountryName);

            tvCityName.setText(s);
            tvCountryName.setText(st);
        }



            ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }



    }


