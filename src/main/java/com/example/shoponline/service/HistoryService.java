package com.example.shoponline.service;

import com.example.shoponline.model.History;
import com.example.shoponline.repository.HistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {
    private HistoryRepository historyRepository;

    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    public List<History> retrieveHistory() {
        return historyRepository.findAll();
    }

    public void deleteHistoryById(int id) {
         historyRepository.deleteById(id);
    }
}
