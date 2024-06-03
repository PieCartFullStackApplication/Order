package com.pie.kart.order.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pie.kart.order.Model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    public Order findByTitle(String new_Order); 
    
}
