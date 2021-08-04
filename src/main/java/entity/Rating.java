package entity;

import java.util.Date;

public class Rating extends Attribution{

    int restaurantId;
    int customerId;
    String comment;
    int rating;
    String approvedBy;

    public Rating( int restaurantId, int customerId, String comment, int rating) {
        super( new Date(), new Date(), true);
        this.restaurantId = restaurantId;
        this.customerId = customerId;
        this.comment = comment;
        this.rating = rating;
        this.approvedBy = "admin";
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }
//    public Rating() {
//        super();
//    }
}
