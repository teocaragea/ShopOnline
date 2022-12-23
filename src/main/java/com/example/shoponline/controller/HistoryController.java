package com.example.shoponline.controller;

import com.example.shoponline.model.History;
import com.example.shoponline.service.HistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/history")
public class HistoryController {
    private final HistoryService historyService;

    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }
    @GetMapping
    public ResponseEntity<List<History>> retrieveHistory(){
        return ResponseEntity.ok().body(historyService.retrieveHistory());
    }
    @DeleteMapping
    public ResponseEntity<String> deleteHistory(@PathVariable int id){
        historyService.deleteHistoryById(id);
        return ResponseEntity.ok().body("History with id " + id + " was deleted with success!!");
    }
}
