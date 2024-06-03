package com.pie.kart.order.Service;

import java.util.List;

import com.pie.kart.order.Model.Order;

public interface OrderService {

    public Order createOrder(Order Order);

    public List<Order> getAllOrders();

}
