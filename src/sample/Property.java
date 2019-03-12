package sample;

import javafx.beans.property.*;

public class Property {

    private final StringProperty propertyType;
    private final StringProperty city;
    private final DoubleProperty bedrooms;
    private final DoubleProperty bathrooms;
    private final StringProperty occupancyStatus;
    private final DoubleProperty monthlyRent;;

    public Property(String propertyType, String city, double bedrooms, double bathrooms, String occupancyStatus, double monthlyRent) {
        this.propertyType = new SimpleStringProperty(propertyType);
        this.city = new SimpleStringProperty(city);
        this.bedrooms = new SimpleDoubleProperty(bedrooms);
        this.bathrooms = new SimpleDoubleProperty(bathrooms);
        this.occupancyStatus = new SimpleStringProperty(occupancyStatus);
        this.monthlyRent = new SimpleDoubleProperty(monthlyRent);
    }

    public String getPropertyType() {
        return propertyType.get();
    }

    public StringProperty propertyTypeProperty() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType.set(propertyType);
    }

    public String getCity() {
        return city.get();
    }

    public StringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public double getBedrooms() {
        return bedrooms.get();
    }

    public DoubleProperty bedroomsProperty() {
        return bedrooms;
    }

    public void setBedrooms(double bedrooms) {
        this.bedrooms.set(bedrooms);
    }

    public double getBathrooms() {
        return bathrooms.get();
    }

    public DoubleProperty bathroomsProperty() {
        return bathrooms;
    }

    public void setBathrooms(double bathrooms) {
        this.bathrooms.set(bathrooms);
    }

    public String getOccupancyStatus() {
        return occupancyStatus.get();
    }

    public StringProperty occupancyStatusProperty() {
        return occupancyStatus;
    }

    public void setOccupancyStatus(String occupancyStatus) {
        this.occupancyStatus.set(occupancyStatus);
    }

    public double getMonthlyRent() {
        return monthlyRent.get();
    }

    public DoubleProperty monthlyRentProperty() {
        return monthlyRent;
    }

    public void setMonthlyRent(double monthlyRent) {
        this.monthlyRent.set(monthlyRent);
    }
}
