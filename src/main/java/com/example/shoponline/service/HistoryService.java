package com.example.shoponline.service;

import com.example.shoponline.model.History;
import com.example.shoponline.repository.DeliveryRepository;
import com.example.shoponline.repository.HistoryRepository;
import org.springframework.stereotype.Service;
import com.example.shoponline.model.Delivery;

import java.util.List;

@Service
public class HistoryService {
    private HistoryRepository historyRepository;
    private DeliveryRepository deliveryRepository;

    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    public List<History> retrieveHistory() {
        return historyRepository.findAll();
    }

    public History saveNewHistory(History history, int deliveryId){
        Delivery delivery = deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new RuntimeException("Delivery not found!"));
        history.setDelivery(delivery);
        return historyRepository.save(history);
    }
    public void deleteHistoryById(int id) {
         historyRepository.deleteById(id);
    }
}
