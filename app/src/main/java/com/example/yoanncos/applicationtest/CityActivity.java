package com.example.yoanncos.applicationtest;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.yoanncos.applicationtest.fragments.CityFragment;

/**
 * Created by yoann_000 on 11/05/2015.
 */
public class CityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(this, "CityActivtiy: Changement d'orientation",
                    Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        if (savedInstanceState == null){
           CityFragment cityFragment = new CityFragment();
           cityFragment.setArguments(getIntent().getExtras());
           getFragmentManager().beginTransaction().add(R.id.containerCity, cityFragment).commit();
        }

            ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }



    }


