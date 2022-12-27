package com.example.shoponline.service;

import com.example.shoponline.model.Delivery;
import com.example.shoponline.repository.DeliveryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DeliveryServiceTests {

    @InjectMocks
    DeliveryService deliveryService;

    @Mock
    DeliveryRepository deliveryRepository;

    @Test
    @DisplayName("Retrieving all deliveries")
    void testRetrieveDeliveries(){
        Delivery delivery = new Delivery();
        delivery.setRepayment(false);
        List<Delivery> deliveryList = new ArrayList<>();
        deliveryList.add(delivery);
        when(deliveryRepository.findAll()).thenReturn(deliveryList);
        List<Delivery> results = deliveryService.retrieveDeliveries();
        assertEquals(results.size(),deliveryList.size());
    }
}
