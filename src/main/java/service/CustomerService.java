package service;

import entity.Address;
import entity.Customer;
import exception.EntityNotFound;
import repository.CustomerRepository;

import java.util.Date;

public class CustomerService {

    CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    private static CustomerService singleTonInstance = null;
    private CustomerService(){

    }
    public static CustomerService getSingleTonInstance(){
        if(singleTonInstance ==null){
            singleTonInstance =new CustomerService();
        }
        return singleTonInstance;
    }

    public int registerUser(String phone, String name,String gender,String buildingName,String areaName, String pinCode){
        if(phone==null || phone.isEmpty() ){
            System.out.println("Phone number can not be null\n");
            throw new RuntimeException("phone not valid");
        }
        Customer customer = new Customer(new Date(), new Date(), true, name,
                new Address(buildingName, areaName, pinCode),
                phone,gender);
        customerRepository.add(customer);

        System.out.println("Customer registered : "+customer);
        return customer.getId();
    }

    public Customer getById(int id) throws EntityNotFound {
        return customerRepository.getById(id);
    }

}
