package com.example.shoponline.service;

import com.example.shoponline.model.NaturalStone;
import com.example.shoponline.repository.NaturalStoneRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.data.web.JsonPath;
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

    public NaturalStone updateName(String name, int id) {
        NaturalStone ns = new NaturalStone();
        ns = naturalStoneRepository.findById(id).get();
        if (name.contains(">=")){
            name = name.substring(12,name.length()-4);
        }
        ns.setName(name);
        return naturalStoneRepository.save(ns);
    }
}
