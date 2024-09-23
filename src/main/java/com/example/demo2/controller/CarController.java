package com.example.demo2.controller;
import com.example.demo2.model.Car;
import com.example.demo2.service.ICarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cars")
public class CarController
{
    private final ICarService iCarService;

    public CarController(ICarService iCarService) {
        this.iCarService = iCarService;
    }

    @GetMapping("{id}")
 public ResponseEntity<Car> getCar(@PathVariable Integer id)
 {
     return ResponseEntity.ok(iCarService.getCar(id));
 }

    @GetMapping("all")
    public ResponseEntity<List<Car>> getAllCars(@RequestParam(value="type", required = false) String type)
    {
        return ResponseEntity.ok(iCarService.getAllCars(type));
    }

//    @GetMapping("type")   //method name queries
//    public ResponseEntity<List<Car>> getAllCarsByNonSuv(@RequestParam String type)
//    {
//        return ResponseEntity.ok(iCarService.getAllCarsByNonSuv(type));
//    }

    @GetMapping("company")
    public ResponseEntity<List<Car>> getAllCarsByCompany(@RequestParam String company)
    {
        return ResponseEntity.ok(iCarService.getAllCarsByCompany(company));
    }

    @PostMapping()
    public ResponseEntity<String> create(@RequestBody Car car)
    {
        return ResponseEntity.ok(iCarService.createCar(car));
    }

    @PutMapping()
    public ResponseEntity<String> updateCar(@RequestBody Car updatedCarDetails)
    {
        return ResponseEntity.ok(iCarService.updateCar(updatedCarDetails));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCar(@PathVariable Integer id)
    {
        return ResponseEntity.ok(iCarService.deleteCar(id));
    }
}
