package com.example.yoanncos.applicationtest;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Yoann.Cos on 04/05/2015.
 */
public class CityListActivity extends AppCompatActivity {


    private String[] mMenuSections;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_city);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        final ArrayList<City> arrayListCity = new ArrayList<>();
        initList(arrayListCity);

        final CityAdapter cityAdapter = new CityAdapter(this, R.layout.row_city, arrayListCity);
        ListView listCityCountry = (ListView)findViewById(R.id.listeVille);
        listCityCountry.setAdapter(cityAdapter);

        listCityCountry.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                City selectedItem = (City)cityAdapter.getItem(position);
                Log.v("City", "Ville selectionnée : "
                        + selectedItem.getCityName());
            }
        });


        mMenuSections = getResources().getStringArray(R.array.navigation_drawer);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mDrawerList = (ListView)findViewById(R.id.left_drawer);

        mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_left,
                mMenuSections));

        mDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout,
                R.string.open_drawer,
                R.string.closed_drawer){

            @Override
            public void onDrawerOpened(View drawerView) {
                Log.d("CityActivity", "onDrawerClosed");
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                Log.d("CityActivity", "onDrawerClosed");
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0 :
                        Intent intent = new Intent(CityListActivity.this, BidonActivity.class);
                        startActivity(intent);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_city, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (mDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }

        switch (id){
            case R.id.action_settings:
                return true;
            case R.id.action_search:
                return true;
            case R.id.action_share:
                return true;
            case R.id.action_information:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }


    private void initList(ArrayList<City> arrayListCity) {

        City paris = new City();
        paris.setCityName("Paris");
        paris.setCountryName("France");
        arrayListCity.add(paris);

        City madrid = new City();
        madrid.setCityName("Madrid");
        madrid.setCountryName("Espagne");
        arrayListCity.add(madrid);

        City londres = new City();
        londres.setCityName("Londres");
        londres.setCountryName("Angleterre");
        arrayListCity.add(londres);

        City munich = new City();
        munich.setCityName("Berlin");
        munich.setCountryName("Allemagne");
        arrayListCity.add(munich);

        City rome = new City();
        rome.setCityName("Rome");
        rome.setCountryName("Italie");
        arrayListCity.add(rome);

        City lisbone = new City();
        lisbone.setCityName("Lisbone");
        lisbone.setCountryName("Portugal");
        arrayListCity.add(lisbone);
    }


}
