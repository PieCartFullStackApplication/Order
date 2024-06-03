package com.pie.kart.order.Service.Impl;



import java.util.List;
import java.util.Optional;

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
    public void removeOrder(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public Order updateOrder(long id, Order order) throws GenericExceptionThrower {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Order createOrder(Order order) {
        return repo.save(order);
    }
    
    @Override
    public Optional<Order> getOrder(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Order> getAllOrders() {
        return repo.findAll();
    }
}
