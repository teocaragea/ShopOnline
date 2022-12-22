package com.example.shoponline.service;

import com.example.shoponline.model.NaturalStone;
import com.example.shoponline.repository.NaturalStoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NaturalStoneService {
    private NaturalStoneRepository naturalStoneRepository;

    public NaturalStoneService(NaturalStoneRepository naturalStoneRepository) {
        this.naturalStoneRepository = naturalStoneRepository;
    }

    public  NaturalStone saveNewStone(NaturalStone naturalStone) {
        return naturalStoneRepository.save(naturalStone);
    }

    public List<NaturalStone> retrieveStones(){
        return naturalStoneRepository.findAll();
    }
}
