package com.example.yoanncos.applicationtest.Entity;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;

/**
 * Created by Yoann.Cos on 04/05/2015.
 */
public class City {

    private String cityName;
    private String countryName;
    private Drawable cityImg;



    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {

        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Drawable getCityImg() {
        return cityImg;
    }

    public void setCityImg(Drawable cityImg) {
        this.cityImg = cityImg;
    }


    public static void initList(ArrayList<City> arrayListCity) {

        City paris = new City();
        paris.setCityName("Paris");
        paris.setCountryName("France");
      //  paris.setCityImg(ResourcesCompat.getDrawable(getResources(), R.drawable.paros, null));
        arrayListCity.add(paris);

        City madrid = new City();
        madrid.setCityName("Madrid");
        madrid.setCountryName("Espagne");
      //  madrid.setCityImg(ResourcesCompat.getDrawable(getResources(), R.drawable.madrid, null));
        arrayListCity.add(madrid);

        City londres = new City();
        londres.setCityName("Londres");
        londres.setCountryName("Angleterre");
      //  londres.setCityImg(ResourcesCompat.getDrawable(getResources(), R.drawable.londres, null));
        arrayListCity.add(londres);

        City berlin = new City();
        berlin.setCityName("Berlin");
        berlin.setCountryName("Allemagne");
      //  berlin.setCityImg(ResourcesCompat.getDrawable(getResources(), R.drawable.berlin, null));
        arrayListCity.add(berlin);

        City rome = new City();
        rome.setCityName("Rome");
        rome.setCountryName("Italie");
      //  rome.setCityImg(ResourcesCompat.getDrawable(getResources(), R.drawable.rome, null));
        arrayListCity.add(rome);

        City lisbone = new City();
        lisbone.setCityName("Lisbone");
        lisbone.setCountryName("Portugal");
      //  rome.setCityImg(ResourcesCompat.getDrawable(getResources(), R.drawable.lisbonne, null));
        arrayListCity.add(lisbone);
    }

}
