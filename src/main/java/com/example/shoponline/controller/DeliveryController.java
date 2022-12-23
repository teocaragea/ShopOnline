package com.example.shoponline.controller;

import com.example.shoponline.model.Delivery;
import com.example.shoponline.service.DeliveryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }
    @GetMapping
    public ResponseEntity<List<Delivery>> retrieveDelivveries(){
        return ResponseEntity.ok().body(deliveryService.retrieveDeliveries());
    }
}
