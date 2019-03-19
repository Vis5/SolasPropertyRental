package sample;

import javafx.beans.property.*;

public class Property {
    private int RentalPropertyID;
    private String PropertyCode;
    private String PropertyType;
    private String Address;
    private String City;
    private String State;
    private int ZIPCode;
    private int Bedrooms;
    private double Bathrooms;
    private boolean HasCarpet;
    private boolean HardWoodFloor;
    private boolean IndoorGarage;
    private boolean HasWasherDryer;
    private boolean PetsAllowed;
    private String OccupancyStatus;
    private double MonthlyRent;

    public Property(int rentalPropertyID, String propertyCode, String propertyType, String address, String city, String state, int ZIPCode, int bedrooms, double bathrooms, boolean hasCarpet, boolean hardWoodFloor, boolean indoorGarage, boolean hasWasherDryer, boolean petsAllowed, String occupancyStatus, double monthlyRent) {
        RentalPropertyID = rentalPropertyID;
        PropertyCode = propertyCode;
        PropertyType = propertyType;
        Address = address;
        City = city;
        State = state;
        this.ZIPCode = ZIPCode;
        Bedrooms = bedrooms;
        Bathrooms = bathrooms;
        HasCarpet = hasCarpet;
        HardWoodFloor = hardWoodFloor;
        IndoorGarage = indoorGarage;
        HasWasherDryer = hasWasherDryer;
        PetsAllowed = petsAllowed;
        OccupancyStatus = occupancyStatus;
        MonthlyRent = monthlyRent;
    }

    public int getRentalPropertyID() {
        return RentalPropertyID;
    }

    public String getPropertyCode() {
        return PropertyCode;
    }

    public String getPropertyType() {
        return PropertyType;
    }

    public String getAddress() {
        return Address;
    }

    public String getCity() {
        return City;
    }

    public String getState() {
        return State;
    }

    public int getZIPCode() {
        return ZIPCode;
    }

    public int getBedrooms() {
        return Bedrooms;
    }

    public double getBathrooms() {
        return Bathrooms;
    }

    public boolean getHasCarpet() {
        return HasCarpet;
    }

    public boolean isHardWoodFloor() {
        return HardWoodFloor;
    }

    public boolean isIndoorGarage() {
        return IndoorGarage;
    }

    public boolean isHasWasherDryer() {
        return HasWasherDryer;
    }

    public boolean isPetsAllowed() {
        return PetsAllowed;
    }

    public String getOccupancyStatus() {
        return OccupancyStatus;
    }

    public double getMonthlyRent() {
        return MonthlyRent;
    }
}
