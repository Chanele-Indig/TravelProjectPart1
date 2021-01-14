package com.example.travelproject.ui;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.travelproject.data.TravelRepository;
import com.example.travelproject.entities.Travel;

public class AddTravelVM extends ViewModel {

    protected TravelRepository repository = new TravelRepository();


    public MutableLiveData<Boolean> getIsSuccess() {
        return repository.getDataBase().getIsSuccess();
    }


    public void insertTravel(Travel travel) {
        repository.insertTravel(travel);
    }
}

