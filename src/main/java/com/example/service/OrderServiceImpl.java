package com.example.service;

import com.example.dao.OrderRepository;
import com.example.entities.TacoOrder;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void addOrder(TacoOrder order) {
        orderRepository.save(order);
    }
}
