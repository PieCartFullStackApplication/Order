package com.pie.kart.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.pie.kart.order.Model.Order;
import com.pie.kart.order.Repo.OrderRepository;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void testGetAllOrders() throws Exception {
        Order order1 = new Order();
        order1.setTitle("Order 1");
        order1.setPrice(100.0);

        Order order2 = new Order();
        order2.setTitle("Order 2");
        order2.setPrice(50.0);

        orderRepository.save(order1);
        orderRepository.save(order2);

        mockMvc.perform(get("/order"))
                .andExpect(status().isOk());

        Iterable<Order> allOrders = orderRepository.findAll();
        assertTrue(allOrders.iterator().hasNext());
    }

    @Test
    void testCreateOrder() throws Exception {
        Order order = new Order();
        order.setTitle("New Order");
        order.setPrice(150.0);

        mockMvc.perform(post("/order/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(order)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.title").value("New Order"));

        Order createdOrder = orderRepository.findByTitle("New Order");
        assertEquals("New Order", createdOrder.getTitle());
    }
}
