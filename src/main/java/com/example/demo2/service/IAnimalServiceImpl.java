package com.example.demo2.service;

import com.example.demo2.model.Animal;
import com.example.demo2.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class IAnimalServiceImpl implements IAnimalService {
    List<Animal> animalList = new ArrayList<>();
    private final AnimalRepository animalRepository;

    public IAnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public Animal getAnimal(Integer id) {
//        Optional<Animal> optionalAnimal=animalList.stream()
//                .filter(a->a.getId().equals(id)).findFirst();
//        if(optionalAnimal.isPresent())
//        {
//            return optionalAnimal.get();
//        }
//        else
//        {
//            throw new RuntimeException("Animal not found with the given Id : "+id);
//        }
        Optional<Animal> optionalAnimal = animalRepository.findById(id);
        if (optionalAnimal.isPresent()) {
            return optionalAnimal.get();
        } else {
            throw new RuntimeException("Animal not found with given Id : " + id);
        }
    }

    @Override
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    @Override
    public String createAnimal(Animal animal) {
//        animalList.add(animal);
//        return "Animal created successfully";
        Animal dbAnimal = new Animal(animal.getId(), animal.getName(), animal.getNature(), animal.getSpeed());
        animalRepository.save(dbAnimal);
        return "Animal created successfully";
    }


    @Override
    public String updateAnimal(Animal updatedAnimalDetails) {
//        Optional<Animal> optionalAnimal=animalList.stream()
//                .filter(a->a.getId().equals(id)).findFirst();
//        if(optionalAnimal.isPresent())
//        {
//            Animal updatedAnimal=optionalAnimal.get();
//            updatedAnimal.setId(updatedAnimalDetails.getId());
//            updatedAnimal.setName(updatedAnimalDetails.getName());
//            updatedAnimal.setNature(updatedAnimalDetails.getNature());
//            updatedAnimal.setSpeed(updatedAnimalDetails.getSpeed());
//            return "Animal updated successfully "+updatedAnimal;
//        }
//        else
//        {
//            throw new RuntimeException("Animal not found with given Id : "+id);
//        }
        Optional<Animal> optionalAnimal = animalRepository.findById(updatedAnimalDetails.getId());
        if (optionalAnimal.isPresent()) {
            Animal dbAnimal = optionalAnimal.get();
            dbAnimal.setId(updatedAnimalDetails.getId());
            dbAnimal.setName(updatedAnimalDetails.getName());
            dbAnimal.setNature(updatedAnimalDetails.getNature());
            dbAnimal.setSpeed(updatedAnimalDetails.getSpeed());
            animalRepository.save(dbAnimal);
            return "Animal updated successfully";
        }
        else
        {
            throw new RuntimeException("Animal not found with the given Id : "+updatedAnimalDetails.getId());
        }
    }

    @Override
    public String deleteAnimal(Integer id) {
//        Optional<Animal> optionalAnimal=animalList.stream()
//                .filter(a->a.getId().equals(id)).findFirst();
//        if(optionalAnimal.isPresent())
//        {
//            animalList.remove(optionalAnimal.get());
//            return "Animal deleted successfully";
//        }
//        else
//        {
//            throw new RuntimeException("Animal not found with the given Id : "+id);
//        }
        Optional<Animal> optionalAnimal = animalRepository.findById(id);
        if (optionalAnimal.isPresent()) {
            animalRepository.delete(optionalAnimal.get());
            return "Animal deleted successfully";
        } else {
            throw new RuntimeException("Animal not found with the given Id : " + id);
        }
    }
}
