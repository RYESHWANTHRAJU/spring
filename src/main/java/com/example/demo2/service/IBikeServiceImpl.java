package com.example.demo2.service;

import com.example.demo2.model.Bike;
import com.example.demo2.repository.BikeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class IBikeServiceImpl implements IBikeService{
    private final BikeRepository bikeRepository;

    public IBikeServiceImpl(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    @Override
    public Bike getBike(Integer id) {
        Optional<Bike> optionalBike=bikeRepository.findById(id);
        if(optionalBike.isPresent())
        {
            return optionalBike.get();
        }
        else {
            throw new RuntimeException("Bike not found with the given Id :"+id);
        }
    }

    @Override
    public List<Bike> getAllBikes() {
        return bikeRepository.findAll();
    }

    @Override
    public String createBike(Bike bike) {
        Bike dbBike=new Bike(bike.getId(),bike.getModel(),bike.getCompany(),bike.getCc(),bike.getMileage(),bike.getPrice());
        bikeRepository.save(dbBike);
        return "Bike created successfully";
    }

    @Override
    public String updateBike(Bike bike) {
        Optional<Bike> optionalBike=bikeRepository.findById(bike.getId());
        if(optionalBike.isPresent())
        {
            Bike dbBike=optionalBike.get();
            dbBike.setId(bike.getId());
            dbBike.setModel(bike.getModel());
            dbBike.setCompany(bike.getCompany());
            dbBike.setCc(bike.getCc());
            dbBike.setMileage(bike.getMileage());
            dbBike.setPrice(bike.getPrice());
            bikeRepository.save(dbBike);
            return "Bike updated successfully ";
        }
        else
        {
            throw new RuntimeException("Bike not found with the given Id: "+bike.getId());
        }
    }

    @Override
    public String deleteBike(Integer id) {
        Optional<Bike> optionalBike=bikeRepository.findById(id);
        if(optionalBike.isPresent())
        {
            bikeRepository.delete(optionalBike.get());
            return "Bike deleted successfully";
        }
        else {
            throw new RuntimeException("Bike not found with the given Id :"+id);
        }
    }

    @Override
    public List<Bike> getAllBikesByCc(Integer cc) {
        return bikeRepository.findByCc(cc);
    }

    @Override
    public List<Bike> getAllBikesByCompany(String company) {
        return bikeRepository.findByCompany(company);
    }
}
