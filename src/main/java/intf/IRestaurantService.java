package intf;

import constants.RestaurantSpecialization;
import entity.Restaurant;

import java.util.List;

public interface IRestaurantService {

    List<Restaurant> getAllRestaurantsOfSpecialization(RestaurantSpecialization Specialization);

    Restaurant getRestaurantById(int restaurantId);
}
