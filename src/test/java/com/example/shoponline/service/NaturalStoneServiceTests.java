package com.example.shoponline.service;

import com.example.shoponline.model.NaturalStone;
import com.example.shoponline.repository.NaturalStoneRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class NaturalStoneServiceTests {

    @InjectMocks
    NaturalStoneService naturalStoneService;

    @Mock
    NaturalStoneRepository naturalStoneRepository;

    @Test
    @DisplayName("Retrieve all stones")
    void testRetrieveStones(){

        NaturalStone naturalStone = new NaturalStone();
        naturalStone.setName("Ametist");
        List<NaturalStone> stones = new ArrayList<>();
        stones.add(naturalStone);

        when(naturalStoneRepository.findAll()).thenReturn(stones);

        List<NaturalStone> results = naturalStoneService.retrieveStones();

        assertEquals(results.size(), stones.size());

    }

    @Test
    @DisplayName("Adding new stone")
    void testAddStone(){
        NaturalStone naturalStone = new NaturalStone();
        naturalStone.setName("Ametist");
        when(naturalStoneRepository.save(naturalStone)).thenReturn(naturalStone);

        NaturalStone result = naturalStoneService.saveNewStone(naturalStone);

        assertEquals(result.getName(),naturalStone.getName());
    }

    @Test
    @DisplayName("Update stone name")
    void testUpdateStoneName(){
        NaturalStone naturalStone = new NaturalStone();
        naturalStone.setName("Ametist");
        when(naturalStoneRepository.findById(naturalStone.getStoneId())).thenReturn(Optional.of(naturalStone));
        when(naturalStoneRepository.save(naturalStone)).thenReturn(naturalStone);

        NaturalStone result = naturalStoneService.updateName("Malachit", naturalStone.getStoneId());

        assertEquals("Malachit", result.getName());
    }
}
