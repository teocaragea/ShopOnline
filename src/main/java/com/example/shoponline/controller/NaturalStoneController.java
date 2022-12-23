package com.example.shoponline.controller;

import com.example.shoponline.model.NaturalStone;
import com.example.shoponline.repository.NaturalStoneRepository;
import com.example.shoponline.service.NaturalStoneService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/stone")
public class NaturalStoneController {
    private final NaturalStoneService naturalStoneService;
    private final NaturalStoneRepository naturalStoneRepository;

    public NaturalStoneController(NaturalStoneService naturalStoneService,
                                  NaturalStoneRepository naturalStoneRepository) {
        this.naturalStoneService = naturalStoneService;
        this.naturalStoneRepository = naturalStoneRepository;
    }
    @PostMapping("/add")
    public ResponseEntity<NaturalStone> saveStone(@RequestBody NaturalStone naturalStone){
        return ResponseEntity.ok().body(naturalStoneService.saveNewStone(naturalStone));
    }
    @GetMapping
    public ResponseEntity<List<NaturalStone>> retrieveStones(){
        return ResponseEntity.ok().body(naturalStoneService.retrieveStones());
    }
    @PutMapping("/new")
    public ResponseEntity<NaturalStone> addOrUpdate(@RequestBody NaturalStone naturalStone){
        return ResponseEntity.ok().body(naturalStoneService.saveNewStone(naturalStone));
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<NaturalStone> updateName(@RequestBody String name, @PathVariable int id){
        return ResponseEntity.ok().body(naturalStoneService.updateName(name,id));
    }
}
