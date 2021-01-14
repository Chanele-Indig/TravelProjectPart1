package com.example.travelproject.data;
import androidx.lifecycle.MutableLiveData;

import com.example.travelproject.entities.Travel;

public interface IDataBase {
    void insertTravel(Travel travel);
    MutableLiveData<Boolean> getIsSuccess();
}
