package com.example.shoponline.service;

import com.example.shoponline.model.Delivery;
import com.example.shoponline.repository.DeliveryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class DeliveryService {
    private DeliveryRepository deliveryRepository;

    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }
    public List<Delivery> retrieveDeliveries(){
        return deliveryRepository.findAll();
    }
}
