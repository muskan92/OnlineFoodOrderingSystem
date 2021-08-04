package service;

import constants.OrderState;
import entity.OrderDetail;
import exception.EntityNotFound;
import intf.IOrderManagementService;
import intf.PricingStrategy;
import repository.OrderRepository;

public class OrderManagementService implements IOrderManagementService {

    OrderRepository orderRepository;
    PricingStrategy pricingStrategy;

    public OrderManagementService(OrderRepository orderRepository, PricingStrategy pricingStrategy) {
        this.orderRepository = orderRepository;
        this.pricingStrategy = pricingStrategy;
    }

    @Override
    public OrderDetail placeOrder(OrderDetail orderDetail) {

        double discountedPrice = pricingStrategy.getDiscountedPrice(orderDetail.getTotal());
        orderDetail.setFinalAmount(discountedPrice);
        orderDetail.setDiscount(orderDetail.getTotal()-discountedPrice);
        orderRepository.add(orderDetail);
        System.out.println("Order is placed for "+orderDetail.getCustomer().getName()+" with orderId "+orderDetail.getId());
        return orderDetail;
    }

    @Override
    public OrderState updateOrderStatus(int orderId, OrderState orderState) throws EntityNotFound {

        OrderDetail orderDetail = orderRepository.getById(orderId);
        System.out.println("Order status updated from "+orderDetail.getOrderState()+" to "+orderState);
        orderRepository.getById(orderId).setOrderState(orderState);

        return orderState;
    }
}
