package com.example.keretaku.repositories;

import androidx.lifecycle.LiveData;

import com.example.keretaku.models.TrainStationModel;
import com.example.keretaku.request.TrainStationApiClient;

import java.util.List;

public class TrainStationRepository {
    private static TrainStationRepository instance;
    private TrainStationApiClient trainStationApiClient;

    public static TrainStationRepository getInstance() {
        if (instance == null){
            instance = new TrainStationRepository();
        }

        return instance;
    }

    private TrainStationRepository() {
        trainStationApiClient = TrainStationApiClient.getInstance();
    }

    public LiveData<List<TrainStationModel>> getTrainStationList(){
        return trainStationApiClient.getTrainStationList();
    }

    public void getTrainStationListData(){
        trainStationApiClient.getTrainStationListData();
    }
}
