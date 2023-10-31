package com.weather.forecast.api.service;


import com.weather.forecast.api.model.OrderItem;
import com.weather.forecast.api.repository.OrderItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @Transactional
    public OrderItem save(OrderItem orderItem){

        return orderItemRepository.save(orderItem);
    }

    public Optional<OrderItem> findByID(String id){
        return orderItemRepository.findById(id);
    }

    public List<OrderItem> findAll() {
        return orderItemRepository.findAll();
    }

    @Transactional
    public void deleteOrderItemByID(String id) {
        orderItemRepository.deleteById(id);
    }
}