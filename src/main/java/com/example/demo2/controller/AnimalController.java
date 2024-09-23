package com.example.demo2.controller;
import com.example.demo2.model.Animal;
import com.example.demo2.service.IAnimalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("animals")
public class AnimalController
{
    private final IAnimalService iAnimalService;

    public AnimalController(IAnimalService iAnimalService) {
        this.iAnimalService = iAnimalService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Animal> getAnimal(@PathVariable Integer id)
    {
        return ResponseEntity.ok(iAnimalService.getAnimal(id));
    }

    @GetMapping("all")
    public ResponseEntity<List<Animal>> getAllAnimals()
    {
        return ResponseEntity.ok(iAnimalService.getAllAnimals());
    }

    @PostMapping
    public ResponseEntity<String> createAnimal(@RequestBody Animal animal)
    {
        return ResponseEntity.ok(iAnimalService.createAnimal(animal));
    }

    @PutMapping()
    public ResponseEntity<String> updateAnimal(@RequestBody Animal updatedAnimalDetails)
    {
        return ResponseEntity.ok(iAnimalService.updateAnimal(updatedAnimalDetails));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAnimal(@PathVariable Integer id)
    {
        return ResponseEntity.ok(iAnimalService.deleteAnimal(id));
    }
}


