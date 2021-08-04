package repository;

import entity.Attribution;
import entity.Customer;
import exception.EntityNotFound;

import java.util.HashMap;
import java.util.Map;

public class CustomerRepository implements CrudOperationsIntf<Customer>{

    Map<Integer, Customer> attributionMap = new HashMap<>();

    @Override
    public void add(Customer a) {
        attributionMap.put(a.getId(),a);
    }

    @Override
    public void update(int id, Customer a) throws EntityNotFound {
        if(attributionMap.containsKey(id)) {
            attributionMap.put(id, a);
        }else {
            throw new EntityNotFound(a.getClass()+" "+id);
        }

    }

    public Customer getById(int id) throws EntityNotFound {
        if(attributionMap.containsKey(id)) {
            return attributionMap.get(id);
        }else {
            throw new EntityNotFound(" "+id);
        }
    }
}
