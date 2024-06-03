package com.pie.kart.order.Service;

import com.pie.kart.order.Service.Impl.GenericExceptionThrower;

import java.util.List;
import java.util.Optional;

import com.pie.kart.order.Model.Order;

 public interface OrderService {
    public void removeOrder(long id);
    
    public Order updateOrder(long id, Order Order) throws GenericExceptionThrower;

    public Order createOrder(Order Order);
    
    public Optional<Order> getOrder(long id);

    public List<Order> getAllOrders();

}
