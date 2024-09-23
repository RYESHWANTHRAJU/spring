package com.example.demo2.service;

import com.example.demo2.model.Car;
import com.example.demo2.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ICarServiceImpl implements ICarService{
    List<Car> carList=new ArrayList<>();
    private final CarRepository carRepository;

    public ICarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car getCar(Integer id) {
//        Optional<Car> optionalCar=carList.stream()
//                .filter(c->c.getId().equals(id)).findFirst();
        Optional<Car> optionalCar=carRepository.findById(id);
        if(optionalCar.isPresent())
        {
            return optionalCar.get();
        }
        else
        {
            throw new RuntimeException("Car not found with the given Id :"+id);
        }
    }

    @Override
    public List<Car> getAllCars(String type) {
        if(type!=null)
        {
            return carRepository.findByType(type);
        }
        else {
            return carRepository.findAll();
        }
    }

    @Override
    public String createCar(Car car) {
        Car dbCar=new Car(car.getId(),car.getModel(),car.getCompany(),car.getType());
        carRepository.save(dbCar);
        return "Car created successfully";
    }

    @Override
    public String updateCar(Car updatedCarDetails) {
//        Optional<Car> optionalCar=carList.stream()
//                .filter(c->c.getId().equals(id)).findFirst();
//        if(optionalCar.isPresent())
//        {
//            Car updatedCar=optionalCar.get();
//            updatedCar.setId(updatedCarDetails.getId());
//            updatedCar.setModel(updatedCarDetails.getModel());
//            updatedCar.setCompany(updatedCarDetails.getCompany());
//            updatedCar.setType(updatedCarDetails.getType());
//            return "Car updated successfully "+updatedCar;
//        }
        Optional<Car> optionalCar=carRepository.findById(updatedCarDetails.getId());
        if(optionalCar.isPresent())
        {
            Car dbCar=optionalCar.get();
            dbCar.setId(updatedCarDetails.getId());
            dbCar.setModel(updatedCarDetails.getModel());
            dbCar.setCompany(updatedCarDetails.getCompany());
            dbCar.setType(updatedCarDetails.getType());
            carRepository.save(dbCar);
            return "car updated successfully";
        }
        else
        {
            throw new RuntimeException("car not found with the given Id :"+updatedCarDetails.getId());
        }

    }

    @Override
    public String deleteCar(Integer id) {
//        Optional<Car> optionalCar=carList.stream()
//                .filter(c->c.getId().equals(id)).findFirst();
        Optional<Car> optionalCar=carRepository.findById(id);
        if(optionalCar.isPresent())
        {
            Car dbCar=optionalCar.get();
            carRepository.delete(dbCar);
            return "Car deleted Successfully";
        }
        else {
            throw new RuntimeException("Car not found with the given Id :"+id);
        }
    }

//    @Override
//    public List<Car> getAllCarsByNonSuv(String type) {
//        return carRepository.findByType(type);
//    }

    @Override
    public List<Car> getAllCarsByCompany(String company) {
        return carRepository.findByCompany(company);

    }
}
