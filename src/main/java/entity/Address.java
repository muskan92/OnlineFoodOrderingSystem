package entity;

import java.util.Date;

public class Address extends Attribution
{
    String buildingNumber;
    String BuildingName;
    String areaName;
    String city;
    String state;
    String country;
    String pin;

    public Address(String buildingName, String areaName, String pin) {
        super(new Date(), new Date(), true);
        BuildingName = buildingName;
        this.areaName = areaName;
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "Address{" +
                "buildingNumber='" + buildingNumber + '\'' +
                ", BuildingName='" + BuildingName + '\'' +
                ", areaName='" + areaName + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", pin='" + pin + '\'' +
                ", id=" + id +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", isActive=" + isActive +
                '}';
    }
}
