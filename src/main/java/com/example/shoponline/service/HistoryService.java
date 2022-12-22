package com.example.shoponline.service;

import com.example.shoponline.repository.HistoryRepository;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {
    private HistoryRepository historyRepository;

    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }
}
