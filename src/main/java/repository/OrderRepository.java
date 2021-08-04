package repository;

import entity.Attribution;
import entity.OrderDetail;
import exception.EntityNotFound;

import java.util.HashMap;
import java.util.Map;

public class OrderRepository implements CrudOperationsIntf<OrderDetail>{

    Map<Integer, OrderDetail> attributionMap = new HashMap<>();

    @Override
    public void add(OrderDetail orderDetail) {

        attributionMap.put(orderDetail.getId(),orderDetail);
    }

    @Override
    public void update(int id, OrderDetail a) throws EntityNotFound {
        if(attributionMap.containsKey(id)) {
            attributionMap.put(id, a);
        }else {
            throw new EntityNotFound(a.getClass()+" "+id);
        }

    }

    public OrderDetail getById(int id) throws EntityNotFound {
        if(attributionMap.containsKey(id)) {
            return attributionMap.get(id);
        }else {
            throw new EntityNotFound(" "+id);
        }
    }
}
