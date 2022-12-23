package com.example.shoponline.repository;

import com.example.shoponline.model.NaturalStone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface NaturalStoneRepository extends JpaRepository<NaturalStone, Integer> {

}
