package com.pie.kart.order.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pie.kart.order.Model.Order;
import com.pie.kart.order.Service.Impl.GenericExceptionThrower;
import com.pie.kart.order.Service.OrderService;


@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable long id) {
        return orderService.getOrder(id).get();
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @DeleteMapping("/{id}")
    public void removeOrderById(@PathVariable long id) {
        orderService.removeOrder(id);
    }

    @PostMapping("/add")
    public Order createOrder(@RequestBody Order Order) {
        return orderService.createOrder(Order);
    }

    @PutMapping("/update/{id}")
    public Order updateOrder(@PathVariable long id, @RequestBody Order Order) throws GenericExceptionThrower {
        return orderService.updateOrder(id, Order);
    }
}
