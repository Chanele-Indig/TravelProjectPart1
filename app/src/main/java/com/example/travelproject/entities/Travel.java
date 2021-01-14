package com.example.travelproject.entities;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
public class Travel {
    public static Integer key=1;
    protected String travelId;
    protected String clientName;
    protected String clientPhone;
    protected String clientEmail;
    protected Date travelDate;
    protected Date arrivalDate;
    protected int NumOfTravelers;
    protected String address;
    protected String destination;
    protected RequestType requesType;
    protected HashMap<String, Boolean> company;

    public Travel()
    {
        this.travelId = key.toString();
        key=key+1;
        this.requesType=RequestType.sent;
    }
    public Travel(String clientName, String clientPhone, String clientEmail, Date travelDate, Date arrivalDate,String address,
            String Destination, HashMap<String, Boolean> company,RequestType request) {
        this.travelId = key.toString();
        this.clientName = clientName;
        this.clientPhone = clientPhone;
        this.clientEmail = clientEmail;
        this.travelDate = travelDate;
        this.arrivalDate = arrivalDate;
        this.address=address;
        this.destination=Destination;
        this.requesType=request;
        this.company = company;
        key=key+1;
    }

    public String getTravelId() {
        return travelId;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public Date getTravelDate() {
        return travelDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }
    public int getNumOfTravelers() {
        return NumOfTravelers;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }


    public void setNumOfTravelers(int numOfTravelers) {
        NumOfTravelers = numOfTravelers;
    }


    public HashMap<String, Boolean> getCompany() {
        return company;
    }

    public void setTravelId(String travelId) {
        this.travelId = travelId;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public void setTravelDate(Date travelDate) {
        this.travelDate = travelDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setCompany(HashMap<String, Boolean> company) {
        this.company = company;
    }
    public String getKey(){
        return travelId;
    }
    public enum RequestType {
        sent(0), accepted(1), run(2), close(3);
        private final Integer RequestTypeCode;
        RequestType(Integer value) {
            this.RequestTypeCode = value;
        }
        public Integer getCode() {
            return RequestTypeCode;
        }
    }
}
