package com.example.keretaku.response;

import com.example.keretaku.models.TrainStationModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TrainStationResponses {
    @SerializedName("")
    @Expose
    private List<TrainStationModel> trainStations;

    public List<TrainStationModel> getTrainStations() {
        return trainStations;
    }

    @Override
    public String toString() {
        return "TrainStationResponses{" +
                "trainStations=" + trainStations +
                '}';
    }
}
