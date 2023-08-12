package com.example.keretaku.request;

import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.keretaku.models.TrainStationModel;
import com.example.keretaku.response.TrainStationResponses;
import com.example.keretaku.utils.AppExecutor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Response;

public class TrainStationApiClient {
    private static TrainStationApiClient instance;

    public static TrainStationApiClient getInstance() {
        if (instance == null){
            instance = new TrainStationApiClient();
        }
        return instance;
    }

    // Live Data
    private MutableLiveData<List<TrainStationModel>> trainStationLiveData;

    // Global Variable for Runnable
    private TrainStationRunnable trainStationRunnable;

    private TrainStationApiClient(){
        trainStationLiveData = new MutableLiveData<>();
    }

    public LiveData<List<TrainStationModel>> getTrainStationList() {
        return trainStationLiveData;
    }

    public void  getTrainStationListData(){
        if(trainStationRunnable != null){
            trainStationRunnable = null;
        }

        trainStationRunnable = new TrainStationRunnable();

        final Future handler = AppExecutor.getInstance().getmNetworkIO().submit(trainStationRunnable);

        AppExecutor.getInstance().getmNetworkIO().schedule(() -> {
            // canceling retrofit call
            handler.cancel(true);
        },3000, TimeUnit.MILLISECONDS);
    }

    // retrieve data from rest API using runnable
    private class TrainStationRunnable implements Runnable {
       boolean cancelRequest;

       public TrainStationRunnable() {
           cancelRequest = false;
       }

        @Override
        public void run() {
            // getting request
            try {
                Response response = getTrainStationList().execute();

                if(cancelRequest){
                    return;
                }

                if (response.isSuccessful()){
                    if(response.code() == 200) {
                        // retrieve data
                        assert response.body() != null;
                        List<TrainStationModel> trainStationList = new ArrayList<>(((TrainStationResponses) response.body()).getTrainStations());

                        // send data to live data
                        // post value -> using background thread
                        // set value
                        trainStationLiveData.postValue(trainStationList);
                    } else {
                        assert response.errorBody() != null;
                        System.out.println(response.errorBody().string());
                        trainStationLiveData.postValue(null);
                    }
                } else {
                    System.out.println("response failed");
                    trainStationLiveData.postValue(null);
                }

            }  catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // method getTrainStation
        private Call<TrainStationResponses> getTrainStationList(){
            return ApiService.getTrainStationApi().getTrainStationList();
        }

    }
}
