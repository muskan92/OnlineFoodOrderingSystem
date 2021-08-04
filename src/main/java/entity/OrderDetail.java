package entity;

import constants.OrderState;

import java.util.Date;
import java.util.List;

public class OrderDetail extends Attribution{

    Restaurant restaurant;
    Customer customer;
    List<Food> lineItems;
    double total;
    double discount = 0;
    double finalAmount = total;
    OrderState orderState = OrderState.CREATED;

    public OrderDetail(Restaurant restaurant, Customer customer, List<Food> lineItems) {
        super(new Date(), new Date(), true);
        this.restaurant = restaurant;
        this.customer = customer;
        this.lineItems = lineItems;
        this.total = calculateTotal(lineItems);
    }

    double calculateTotal(List<Food> lineItems){
        for(Food food : lineItems){
            total += food.getPrice();
        }
        return total;
    }



    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Food> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<Food> lineItems) {
        this.lineItems = lineItems;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    public double getDiscount() {

        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(double finalAmount) {
        this.finalAmount = finalAmount;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "restaurant=" + restaurant.getName() +
                ", customer=" + customer.getName() +
                ", lineItems=" + lineItems +
                ", total=" + total +
                ", discount=" + discount +
                ", finalAmount=" + finalAmount +
                ", orderState=" + orderState +
                '}';
    }
}
