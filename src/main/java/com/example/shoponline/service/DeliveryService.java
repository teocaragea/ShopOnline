package com.example.shoponline.service;

import com.example.shoponline.repository.DeliveryRepository;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
    private DeliveryRepository deliveryRepository;

    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }
}
