package com.example.travelproject.data;

import com.example.travelproject.entities.Travel;
import androidx.lifecycle.MutableLiveData;

public class TravelRoomDB implements IDataBase{

    protected MutableLiveData<Boolean> isSuccess = new MutableLiveData<Boolean>();


    @Override
    public void insertTravel(Travel travel) {

    }

    @Override
    public MutableLiveData<Boolean> getIsSuccess() {
        return isSuccess;
    }
}