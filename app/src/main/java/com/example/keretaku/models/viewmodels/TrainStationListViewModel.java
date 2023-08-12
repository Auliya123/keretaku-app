package com.example.keretaku.models.viewmodels;

import androidx.lifecycle.LiveData;

import com.example.keretaku.models.TrainStationModel;
import com.example.keretaku.repositories.TrainStationRepository;

import java.util.List;

public class TrainStationListViewModel {
    private TrainStationRepository trainStationRepository;

    public TrainStationListViewModel(){
        trainStationRepository = TrainStationRepository.getInstance();
    }

    public LiveData<List<TrainStationModel>> getTrainStationList(){
        return trainStationRepository.getTrainStationList();
    }

    public void getTrainStationListData(){
        trainStationRepository.getTrainStationListData();
    }
}
