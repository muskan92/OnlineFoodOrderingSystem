package entity;

import java.util.Date;

public class Customer extends Attribution{

    String Name;
    Address address;
    String mobile;
    String gender;

    public Customer( Date createdAt, Date updatedAt, boolean isActive, String name, Address address, String mobile,String gender) {
        super( createdAt, updatedAt, isActive);
        Name = name;
        this.address = address;
        this.mobile = mobile;
        this.gender = gender;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Name='" + Name + '\'' +
                ", address=" + address +
                ", mobile='" + mobile + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
