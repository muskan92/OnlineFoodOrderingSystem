package entity;

import constants.RestaurantSpecialization;

import java.util.Date;
import java.util.List;

public class Restaurant extends Attribution{

    String Name;
    RestaurantSpecialization specialization;
    List<Food> menuItems;
    Address address;
    Double rating;
    String mobile;
    boolean isOpen;

    public Restaurant(String name, RestaurantSpecialization specialization, List<Food> menuItems, Address address, String mobile) {
        super(new Date(), new Date(), true);
        Name = name;
        this.specialization = specialization;
        this.menuItems = menuItems;
        this.address = address;
        this.rating = null;
        this.mobile = mobile;
        this.isOpen = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public RestaurantSpecialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(RestaurantSpecialization specialization) {
        this.specialization = specialization;
    }

    public List<Food> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<Food> menuItems) {
        this.menuItems = menuItems;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "Name='" + Name + '\'' +
                ", specialization=" + specialization +
                ", menuItems=" + menuItems +
                ", address=" + address.BuildingName +
                ", rating=" + rating +
                ", mobile='" + mobile + '\'' +
                ", isOpen=" + isOpen +
                '}';
    }
}
