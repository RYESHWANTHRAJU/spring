package com.example.demo2.controller;
import com.example.demo2.model.Bus;
import com.example.demo2.service.IBusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("buses")
public class BusController
{
    private final IBusService iBusService;

    public BusController(IBusService iBusService) {
        this.iBusService = iBusService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Bus> getBus(@PathVariable Integer id)
    {
        return ResponseEntity.ok(iBusService.getBus(id));
    }

    @GetMapping("all")
    public ResponseEntity<List<Bus>> getAllBuses()
    {
        return ResponseEntity.ok(iBusService.getAllBuses());
    }

    @PostMapping
    public ResponseEntity<String> createBus(@RequestBody Bus bus)
    {
        return ResponseEntity.ok(iBusService.createBus(bus));
    }

    @PutMapping
    public ResponseEntity<String> updateBus(@RequestBody Bus updatedBusDetails)
    {
        return ResponseEntity.ok(iBusService.updateBus(updatedBusDetails));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBus(@PathVariable Integer id)
    {
        return ResponseEntity.ok(iBusService.deleteBus(id));
    }

}
