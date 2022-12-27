package com.example.shoponline.service;

import com.example.shoponline.model.Order;
import com.example.shoponline.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTests {

    @InjectMocks OrderService orderService;

    @Mock
    OrderRepository orderRepository;

    @Test
    @DisplayName("Test saving new Order")
    void testAddOrder(){
        Order order = new Order();
        order.setPrice(Double.valueOf(25));
        when(orderRepository.save(order)).thenReturn(order);

        Order result = orderService.saveNewOrder(order);

        assertEquals(result.getPrice(), order.getPrice());

    }

    @Test
    @DisplayName("Retrieve all orders")
    void testRetrieveOrders(){
        Order order = new Order();
        order.setPrice(Double.valueOf(25));
        List<Order> orders = new ArrayList<>();
        orders.add(order);
        when(orderRepository.findAll()).thenReturn(orders);
        List<Order> results = orderService.retrieveOrders();
        assertEquals(results.size(), orders.size());
    }
    @Test
    @DisplayName("Delete order")
    void testDeleteOrder(){
        Order order = new Order();
        order.setPrice(Double.valueOf(25));

        orderService.deleteById(order.getOrdersId());

        verify(orderRepository, times(1)).deleteById(order.getOrdersId());
    }
}
