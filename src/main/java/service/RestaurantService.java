package service;

import constants.RestaurantSpecialization;
import entity.Address;
import entity.Food;
import entity.Restaurant;
import intf.IRestaurantService;
import repository.RestaurantRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RestaurantService implements IRestaurantService {

    RestaurantRepository restaurantRepository;


    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public int registerRestaurant(String phone, String name, RestaurantSpecialization specialization, List<Food> menuItems, String buildingName, String areaName, String pinCode){
        if(phone==null || phone.isEmpty() ){
            System.out.println("Phone number can not be null\n");
            throw new RuntimeException("phone not valid");
        }

        Restaurant restaurant = new Restaurant(name, specialization, menuItems,
                new Address(buildingName, areaName, pinCode), phone);

        restaurantRepository.add(restaurant);
        System.out.println("Restaurant registered successfully : "+restaurant);
        return restaurant.getId();
    }

    @Override
    public List<Restaurant> getAllRestaurantsOfSpecialization(RestaurantSpecialization Specialization) {

        System.out.println("getting all restaurants of "+Specialization +" specialization...");
        return restaurantRepository.getAllRestaurants().stream()
                .filter(it-> it.getSpecialization() == Specialization)
                .collect(Collectors.toList()) ;

    }

    @Override
    public Restaurant getRestaurantById(int restaurantId) {
        return restaurantRepository.getById(restaurantId);
    }
}
