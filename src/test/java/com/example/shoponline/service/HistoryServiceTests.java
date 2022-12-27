package com.example.shoponline.service;

import com.example.shoponline.model.*;
import com.example.shoponline.repository.DeliveryRepository;
import com.example.shoponline.repository.HistoryRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class HistoryServiceTests {

    @InjectMocks
    private HistoryService historyService;

    @Mock
    private HistoryRepository historyRepository;
    @Mock
    private DeliveryRepository deliveryRepository;


    @Test
    @DisplayName("Save history test positive flow")
    void testSaveNewHistory(){
        User user = new User("tcaragea", "pass1244");
        Double price = 25.00;
        Product product1 = new Product(Product.Type.Bratara, 5.00);
        Product product2 = new Product(Product.Type.Lantisor, 12.00);
        Order order1 = new Order(price, Set.of(product1,product2));
        Set<Order> orders = new HashSet<>();
        orders.add(order1);
        Date d1 = new Date(2023,11,20);
        History history = new History(History.Status.Livrat,d1);
        int deliveryId = 1;

        Delivery delivery = new Delivery(orders, false, user);
        when(deliveryRepository.findById(deliveryId)).thenReturn(Optional.of(delivery));

        when(historyRepository.save(history)).thenReturn(history);

        History result = historyService.saveNewHistory(history , deliveryId);

        assertEquals(d1, result.getData());
        assertEquals(History.Status.Livrat, history.getStatus());
        assertEquals(false, result.getDelivery().getRepayment());
    }
    @Test
    @DisplayName("Test saving new history negative flow")
    void testNewHistoryNegative(){

        String error = "Delivery not found!";
        User user = new User("tcaragea", "pass1244");
        Double price = 25.00;
        Product product1 = new Product(Product.Type.Bratara, 5.00);
        Product product2 = new Product(Product.Type.Lantisor, 12.00);
        Order order1 = new Order(price, Set.of(product1,product2));
        Set<Order> orders = new HashSet<>();
        orders.add(order1);
        Date d1 = new Date(2023,11,20);
        History history = new History(History.Status.Livrat,d1);
        int deliveryId = 1;

        try{
            History result = historyService.saveNewHistory(history , deliveryId);
        }catch (RuntimeException e){
            assertEquals(error, e.getMessage());
            verify(historyRepository,times(0)).save(any());
        }
    }

    @Test
    @DisplayName("retrieve all histories")
    void testRetrieveHistory(){

        History history = new History();
        Date d1 = new Date(2023,10,20);
        history.setStatus(History.Status.Preg);
        history.setData(d1);
        List<History> histories = new ArrayList<>();
        histories.add(history);
        when(historyRepository.findAll()).thenReturn(histories);

        List<History> results = historyService.retrieveHistory();

        assertEquals(histories.size(),results.size());
        }

        @Test
        @DisplayName("delete one history")
        void testDeleteHistory(){
            History history1 = new History();
            Date d1 = new Date(2023,10,20);
            history1.setStatus(History.Status.Preg);
            history1.setData(d1);


            historyService.deleteHistoryById(history1.getHistoryId());

            verify(historyRepository, times(1)).deleteById(history1.getHistoryId());
        }
}
