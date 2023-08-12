package com.example.keretaku.utils;

import com.example.keretaku.response.TrainStationResponses;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TrainStationApi {
    // train station list
    @GET("stations2")
    Call<TrainStationResponses> getTrainStationList();
}
