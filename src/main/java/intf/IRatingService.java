package intf;

import entity.Rating;

import java.util.List;

public interface IRatingService{

    void createUpdateRating(int customerId,int restaurantId,int rating,String comment);
    boolean deactivateRating(int id);

    /**
     *
     * @param id (restaurentId)
     * @return
     */
    double getAverageRating(int id);
    public List<Rating> getAllRating(int id);
}
