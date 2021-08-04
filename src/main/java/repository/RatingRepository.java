package repository;
import entity.Rating;
import exception.EntityNotFound;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RatingRepository implements CrudOperationsIntf<Rating>{
//restaurantId to ratingList map

    Map<Integer, List<Rating>> attributionMap = new HashMap<>();

    @Override
    public void add(Rating a) {
        List<Rating> ratingList = attributionMap.getOrDefault(a.getRestaurantId(), new ArrayList<>());
        ratingList.add(a);
        attributionMap.put(a.getRestaurantId(),ratingList);
    }

    @Override
    public void update(int id, Rating a) throws EntityNotFound {

    }

    public List<Rating> getAllRatings(int restaurantId){
        return attributionMap.get(restaurantId);
    }

//    @Override
//    public void update(int id, Rating a) throws EntityNotFound {
//        if(attributionMap.containsKey(id)) {
//            attributionMap.put(id, a);
//        }else {
//            throw new EntityNotFound(a.getClass()+" "+id);
//        }
//    }
}
