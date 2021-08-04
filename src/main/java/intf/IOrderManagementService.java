package intf;

import constants.OrderState;
import entity.OrderDetail;
import exception.EntityNotFound;

public interface IOrderManagementService {
    /**
     *
     * @param orderDetail
     * @return orderId
     */
    OrderDetail placeOrder(OrderDetail orderDetail);

    /**
     *
     * @param orderId
     * @return updated order state
     */
    OrderState updateOrderStatus(int orderId, OrderState orderState) throws EntityNotFound;


}
