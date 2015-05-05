package com.example.yoanncos.applicationtest;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Yoann.Cos on 04/05/2015.
 */
public class City implements Parcelable {

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



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }


    //  ///!\ Trop chiant et hors context de passer un drawable, mieux vaut lui passer l'uri


 //  public static Bitmap drawableToBitmap (Drawable drawable) {
 //      if (drawable instanceof BitmapDrawable) {
 //          return ((BitmapDrawable)drawable).getBitmap();
 //      }

 //      Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
 //      Canvas canvas = new Canvas(bitmap);
 //      drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
 //      drawable.draw(canvas);

 //      return bitmap;
 //  }




 //  @Override
 //  public int describeContents() {
 //      return 0;
 //  }

 //  @Override
 //  public void writeToParcel(Parcel dest, int i) {

 //      drawableToBitmap(cityImg);



 //  dest.writeParcelable(,0);
 //  dest.writeString(cityName);
 //  dest.writeString(countryName);

 //  }

 //  public static final Parcelable.Creator<City> CREATOR = new
 //          Parcelable.Creator<City>() {

 //              @Override
 //              public City createFromParcel(Parcel dest) {
 //                  return new City(dest);
 //              }

 //              @Override
 //              public City[] newArray(int size) {
 //                  return new City[size];
 //              }

 //          };


 //  public City(Parcel in) {
 //      this.cityImg = in.read();
 //      this.mLastName = in.readString();
 //      this.mPseudo = in.readString();
 //      this.mMail = in.readString();
 //      this.mTwitter = in.readString();
 //      this.mGooglePlus = in.readString();
 //  }
}
