package com.example.travelproject.data;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.example.travelproject.entities.Travel;

public class FireBaseTravelDB implements IDataBase{

    protected FirebaseDatabase database = FirebaseDatabase.getInstance();
    MutableLiveData<Boolean> isSuccess = new MutableLiveData<Boolean>();

    @Override
    public void insertTravel(Travel travel) {
        DatabaseReference travels = database.getReference("travels");
        String key = travel.getKey();
        travels.child(key)
                .setValue(travel)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        isSuccess.postValue(true);
                    }
                });

    }

    @Override
    public MutableLiveData<Boolean> getIsSuccess() {
        return this.isSuccess;
    }
}
