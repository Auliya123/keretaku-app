package com.example.keretaku.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class TrainStationModel implements Parcelable {
    private String code;
    private String name;
    private String city;
    private String cityname;

    public TrainStationModel(String code, String name, String city, String cityname) {
        this.code = code;
        this.name = name;
        this.city = city;
        this.cityname = cityname;
    }

    protected TrainStationModel(Parcel in) {
        code = in.readString();
        name = in.readString();
        city = in.readString();
        cityname = in.readString();
    }

    public static final Creator<TrainStationModel> CREATOR = new Creator<TrainStationModel>() {
        @Override
        public TrainStationModel createFromParcel(Parcel in) {
            return new TrainStationModel(in);
        }

        @Override
        public TrainStationModel[] newArray(int size) {
            return new TrainStationModel[size];
        }
    };

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCityname() {
        return cityname;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(code);
        parcel.writeString(name);
        parcel.writeString(city);
        parcel.writeString(cityname);
    }

    @Override
    public String toString() {
        return "TrainStationModel{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", cityname='" + cityname + '\'' +
                '}';
    }
}
