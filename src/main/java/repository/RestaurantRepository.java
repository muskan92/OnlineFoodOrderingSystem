package repository;

import entity.Attribution;
import entity.Restaurant;
import exception.EntityNotFound;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RestaurantRepository implements CrudOperationsIntf<Restaurant>{

    Map<Integer, Restaurant> attributionMap = new HashMap<>();

    @Override
    public void add(Restaurant a) {
        attributionMap.put(a.getId(),a);
    }

    @Override
    public void update(int id, Restaurant a) throws EntityNotFound {
        if(attributionMap.containsKey(id)) {
            attributionMap.put(id, a);
        }else {
            throw new EntityNotFound(a.getClass()+" "+id);
        }

    }

    public List<Restaurant> getAllRestaurants(){
         List<Restaurant> restaurantList = attributionMap.values().stream().collect(Collectors.toList());
        return restaurantList;
    }

    public Restaurant getById(int id){
        Restaurant restaurant = attributionMap.get(id);
        return restaurant;
    }
}
