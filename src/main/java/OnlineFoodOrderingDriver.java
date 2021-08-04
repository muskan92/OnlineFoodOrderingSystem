import constants.OrderState;
import constants.RestaurantSpecialization;
import entity.*;
import exception.EntityNotFound;
import repository.CustomerRepository;
import repository.OrderRepository;
import repository.RatingRepository;
import repository.RestaurantRepository;
import service.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Restaurants can only serve one specialized dish.
 * Restaurants can serve in multiple areas.
 * At a time, users can order from one restaurant, and the quantity of food can be more than one.
 * Users should be able to rate any restaurant with or without comment.
 * Rating of a restaurant is the average rating given by all customers.
 *
 * 1.filter based on specialization
 * 2. serve based on distance btwn customer and restaurant -
 * restaurant->location,customer->location : maxServingDistance 3 km
 * 3. orderDetail - check for paid state -> checkout, paymentInitiated, paid, OutForDelivery, cancelled, delivered, return
 * 4. rating - restaurentId,CustomerId, rating, comment, created, updated, approvedBy,isActive
 * 5.
 *
 * /v1.1/FoodOrderingService/placeOrder/{customerId} -> POST
 * {OrderDetails}
 *
 * /v1.1/FoodOrderingService/updateOrderState/orderId - POST
 *
 * /v1.1/FoodOrderingService/rating/customerId - POST
 *
 * /v1.1/FoodOrderingService/getAllRestaurants/{customerId}/{specialization}
 *
 *  --/v1.1/FoodOrderingService/updateLocation/customerId
 *
 *  observer - rating observe
 *  strategy - price - cricket time, occasion,
 */


public class OnlineFoodOrderingDriver {
    public static void main(String[] args) throws EntityNotFound {

        CustomerService customerService = new CustomerService(new CustomerRepository());
        RestaurantService restaurantService = new RestaurantService(new RestaurantRepository());

        OrderManagementService orderManagementService =
                new OrderManagementService(new OrderRepository(),new ChristmasDiscountStrategy());

        RatingService ratingService = new RatingService(customerService,new RatingRepository(),new RatingObserver(restaurantService));

        List<Food> menuItems = new ArrayList<>();
        menuItems.add(new Food( "food1", 100));
        menuItems.add(new Food( "food2", 150));

        int customerId = customerService.registerUser("987654321", "muskaan", "female", "Akshaya", "HSR", "123");
        customerService.registerUser("1234567890", "rahul", "male","HarshitaNilaya","electronicCity", "456");

        restaurantService.registerRestaurant("089763421", "EatFit", RestaurantSpecialization.VEG, menuItems, "CultFit", "HSR", "123");
        restaurantService.registerRestaurant("120987623", "MTR", RestaurantSpecialization.NONVEG, menuItems, "MTR1", "HSR", "456");
        restaurantService.registerRestaurant("120987623", "MTR", RestaurantSpecialization.NONVEG, menuItems, "MTR2", "electronicCity", "456");
        restaurantService.registerRestaurant("120987623", "MTR", RestaurantSpecialization.NONVEG, menuItems, "MTR3", "electronicCity", "456");

        List<Restaurant> restaurantsOfSpecialization = restaurantService.getAllRestaurantsOfSpecialization(RestaurantSpecialization.VEG);

        System.out.println(restaurantsOfSpecialization);

        OrderDetail orderDetail = orderManagementService.placeOrder(new OrderDetail(restaurantsOfSpecialization.get(0), customerService.getById(customerId), menuItems));

        System.out.println(orderDetail);

        orderManagementService.updateOrderStatus(orderDetail.getId(), OrderState.PAID);

        System.out.println(orderDetail);

        ratingService.createUpdateRating(customerId,restaurantsOfSpecialization.get(0).getId(),4,"Good");

        System.out.println(restaurantsOfSpecialization.get(0));
    }
}
