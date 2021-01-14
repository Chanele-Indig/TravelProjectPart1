package com.example.travelproject.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.app.DatePickerDialog;
import android.text.InputType;
import android.widget.Button;
import android.widget.DatePicker;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.example.travelproject.R;
import com.example.travelproject.entities.Travel;
import java.util.Calendar;

public class AddTravelActivity extends AppCompatActivity {
    protected EditText Name,Phone,Email,AddressPickUp, NumDestinatins,NumPassengers,Destination;
    protected AddTravelVM viewModel;
    Date go,arrival;
    DatePickerDialog picker1;
    EditText eText1;
    DatePickerDialog picker2;
    EditText eText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_travel_activity);
        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        eText1 =(EditText) findViewById(R.id.editText1);
        eText1.setInputType(InputType.TYPE_NULL);
        eText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker1 = new DatePickerDialog(AddTravelActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                eText1.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                                go=new Date(year,monthOfYear,dayOfMonth);
                            }
                        }, year, month, day);
                picker1.show();
            }
        });
        eText2 =(EditText) findViewById(R.id.editText2);
        eText2.setInputType(InputType.TYPE_NULL);
        eText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker2 = new DatePickerDialog(AddTravelActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                eText2.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                                arrival=new Date(year,monthOfYear,dayOfMonth);
                            }
                        }, year, month, day);
                picker2.show();
            }
        });
        findControls();
    }
    private void findControls() {
        viewModel = ViewModelProviders.of(this).get(AddTravelVM.class);
        Name = findViewById(R.id.txtName);
        Phone = findViewById(R.id.txtPhone);
        Email = findViewById(R.id.txtEmail);
        AddressPickUp = findViewById(R.id.txtAddressPickUp);
        NumDestinatins = findViewById(R.id.txtDestination);
        NumPassengers = findViewById(R.id.txtNumPassengers);
        Destination=findViewById(R.id.txtDestination);
        viewModel.getIsSuccess().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                Toast.makeText(AddTravelActivity.this, "Travel Inserted", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
    public void btnSaveClick(View view) {
        Travel travel = createTravel();
        viewModel.insertTravel(travel);
    }
    private Travel createTravel() {
        Travel travel = new Travel();
        travel.setTravelDate(go);
        travel.setArrivalDate(arrival);
        travel.setClientPhone(Phone.getText().toString());
        travel.setClientName(Name.getText().toString());
        travel.setClientEmail(Email.getText().toString());
        travel.setAddress(AddressPickUp.getText().toString());
        travel.setDestination(Destination.getText().toString());
        travel.setNumOfTravelers(Integer.parseInt(NumPassengers.getText().toString()));
        return travel;
    }
}