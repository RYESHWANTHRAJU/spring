package com.example.demo2.service;

import com.example.demo2.model.Animal;

import java.util.List;

public interface IAnimalService
{
    Animal getAnimal(Integer id);
    List<Animal> getAllAnimals();
    String createAnimal(Animal animal);
    String updateAnimal(Animal updatedAnimalDetails);
    String deleteAnimal(Integer id);
}
