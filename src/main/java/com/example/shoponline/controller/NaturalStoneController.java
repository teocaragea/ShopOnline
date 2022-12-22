package com.example.shoponline.controller;

import com.example.shoponline.model.NaturalStone;
import com.example.shoponline.service.NaturalStoneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/stone")
public class NaturalStoneController {
    private final NaturalStoneService naturalStoneService;

    public NaturalStoneController(NaturalStoneService naturalStoneService) {
        this.naturalStoneService = naturalStoneService;
    }
    @PostMapping("/add")
    public ResponseEntity<NaturalStone> saveStone(@RequestBody NaturalStone naturalStone){
        return ResponseEntity.ok().body(naturalStoneService.saveNewStone(naturalStone));
    }
    @GetMapping
    public ResponseEntity<List<NaturalStone>> retrieveStones(){
        return ResponseEntity.ok().body(naturalStoneService.retrieveStones());
    }
}
