package service;

import entity.Rating;
import entity.Restaurant;
import intf.IObserver;
import intf.IRatingService;
import repository.RatingRepository;

import java.util.List;

public class RatingService implements IRatingService {

    CustomerService customerService;
    RatingRepository ratingRepository;
    IObserver<RatingMataData> observer;

    public RatingService(CustomerService customerService, RatingRepository ratingRepository, IObserver observer) {
        this.customerService = customerService;
        this.ratingRepository = ratingRepository;
        this.observer = observer;
    }

    @Override
    public void createUpdateRating(int customerId, int restaurantId, int rating, String comment) {

        Rating ratingObj = new Rating(restaurantId, customerId, comment, rating);

        ratingRepository.add(ratingObj);
        double averageRating = getAverageRating(restaurantId);

        observer.notify(new RatingMataData(restaurantId, averageRating));

    }

    public List<Rating> getAllRating(int restaurantId){
        return ratingRepository.getAllRatings(restaurantId);
    }

    @Override
    public boolean deactivateRating(int id) {
        return false;
    }

    @Override
    public double getAverageRating(int id) {
        List<Rating> allRating = getAllRating(id);
        double avgRating =0;
        for(Rating rating : allRating){
            avgRating += rating.getRating();
        }
        avgRating = avgRating/allRating.size();
        return avgRating;
    }
}
