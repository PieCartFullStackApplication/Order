package com.pie.kart.order.Service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pie.kart.order.Model.Order;
import com.pie.kart.order.Repo.OrderRepository;
import com.pie.kart.order.Service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repo;

    @Override
    public Order createOrder(Order order) {
        return repo.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return repo.findAll();
    }
}
