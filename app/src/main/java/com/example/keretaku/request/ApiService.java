package com.example.keretaku.request;

import com.example.keretaku.utils.Credentials;
import com.example.keretaku.utils.TrainStationApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder().baseUrl(Credentials.BASE_URL).addConverterFactory(GsonConverterFactory.create());
    private static Retrofit retrofit = retrofitBuilder.build();
    private static TrainStationApi trainStationApi = retrofit.create(TrainStationApi.class);

    public static TrainStationApi getTrainStationApi() {
        return trainStationApi;
    }
}
