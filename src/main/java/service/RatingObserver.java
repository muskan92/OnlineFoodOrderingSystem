package service;

import entity.Restaurant;
import intf.IObserver;

public class RatingObserver implements IObserver<RatingMataData> {
    RestaurantService restaurantService;

    public RatingObserver(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @Override
    public void notify(RatingMataData metaData) {
        Restaurant restaurant = restaurantService.getRestaurantById(metaData.restaurantId);
        restaurant.setRating(metaData.avgRating);
    }
}

class RatingMataData{
    int restaurantId;
    double avgRating;

    public RatingMataData(int restaurantId, double avgRating) {
        this.restaurantId = restaurantId;
        this.avgRating = avgRating;
    }
}