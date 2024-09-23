package com.example.demo2.service;

import com.example.demo2.model.Bike;

import java.util.List;

public interface IBikeService
{
    Bike getBike(Integer id);
    List<Bike> getAllBikes();
    String createBike(Bike bike);
    String updateBike(Bike bike);
    String deleteBike(Integer id);
    List<Bike> getAllBikesByCc(Integer cc);
    List<Bike> getAllBikesByCompany(String company);
}
