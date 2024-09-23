package com.example.demo2.controller;
import com.example.demo2.model.Bike;
import com.example.demo2.service.IBikeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bikes")
public class BikeController {
    private final IBikeService iBikeService;

    public BikeController(IBikeService iBikeService) {
        this.iBikeService = iBikeService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Bike> getBike(@PathVariable Integer id)
    {
        return ResponseEntity.ok(iBikeService.getBike(id));
    }

    @GetMapping("all")
    public ResponseEntity<List<Bike>> getAllBikes()
    {
        return ResponseEntity.ok(iBikeService.getAllBikes());
    }

    @GetMapping("cc")
    public ResponseEntity<List<Bike>> getAllBikesByCc(@RequestParam Integer cc)
    {
        return ResponseEntity.ok(iBikeService.getAllBikesByCc(cc));
    }

    @GetMapping("company")
    public ResponseEntity<List<Bike>> getAllBikesByCompany(@RequestParam String company)
    {
        return ResponseEntity.ok(iBikeService.getAllBikesByCompany(company));
    }

    @PostMapping()
    public ResponseEntity<String> createBike(@RequestBody Bike bike)
    {
        return ResponseEntity.ok(iBikeService.createBike(bike));
    }

    @PutMapping()
    public ResponseEntity<String> updateBike(@RequestBody Bike bike)
    {
        return ResponseEntity.ok(iBikeService.updateBike(bike));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBike(@PathVariable Integer id)
    {
        return ResponseEntity.ok(iBikeService.deleteBike(id));
    }

}
