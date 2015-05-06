package com.example.yoanncos.applicationtest.Entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Yoann.Cos on 06/05/2015.
 */
public class Mayor implements Parcelable {

    private String name;
    private int age;
    private String city;
    private int experience;

    public Mayor() {
        this.name = name;
        this.age = age;
        this.city = city;
        this.experience = experience;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(city);
        dest.writeInt(age);
        dest.writeInt(experience);
    }

    public static final Parcelable.Creator<Mayor> CREATOR = new
            Parcelable.Creator<Mayor>() {

                @Override
                public Mayor createFromParcel(Parcel source) {
                    return new Mayor(source);
                }

                @Override
                public Mayor[] newArray(int size) {
                    return new Mayor[size];
                }
            };

    public Mayor(Parcel source) {
        this.name = source.readString();
        this.city = source.readString();
        this.age = source.readInt();
        this.experience = source.readInt();
    }
}
