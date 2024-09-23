package com.example.demo2.repository;

import com.example.demo2.model.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BikeRepository extends JpaRepository<Bike,Integer> {
    List<Bike> findByCc(Integer cc);
    List<Bike> findByCompany(String company);
}
