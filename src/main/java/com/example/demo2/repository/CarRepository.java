package com.example.demo2.repository;

import com.example.demo2.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer>
{

    List<Car> findByType(String type);
    List<Car> findByCompany(String company);
}
