package com.example.demo2.service;

import com.example.demo2.model.Car;

import java.util.List;

public interface ICarService {
    Car getCar(Integer id);
    List<Car> getAllCars(String type);
    String createCar(Car car);
    String updateCar(Car updatedCarDetails);
    String deleteCar(Integer id);
   // List<Car> getAllCarsByNonSuv(String type);
    List<Car> getAllCarsByCompany(String company);
}
