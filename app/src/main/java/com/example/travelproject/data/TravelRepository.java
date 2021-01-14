package com.example.travelproject.data;

import com.example.travelproject.entities.Travel;

public class TravelRepository {
    protected IDataBase dataBase = new FireBaseTravelDB();
    protected IDataBase dataBase2 = new TravelRoomDB();


    public IDataBase getDataBase() {
        return dataBase;
    }

    public void setDataBase(IDataBase dataBase) {
        this.dataBase = dataBase;
    }

    public void insertTravel(Travel travel) {
        dataBase.insertTravel(travel);
    }
}
