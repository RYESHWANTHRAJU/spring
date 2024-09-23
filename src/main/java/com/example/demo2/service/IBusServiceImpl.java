package com.example.demo2.service;

import com.example.demo2.model.Bus;
import com.example.demo2.repository.BusRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class IBusServiceImpl implements IBusService{
    private final BusRepository busRepository;
    List<Bus> busList=new ArrayList<>();

    public IBusServiceImpl(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    @Override
    public Bus getBus(Integer id) {
//        Optional<Bus> optionalBus=busList.stream()
//                .filter(b->b.getId().equals(id))
//                .findFirst();
//        if(optionalBus.isPresent())
//        {
//            return optionalBus.get();
//        }
//        else {
//            throw new RuntimeException("Bus not found with the given Id : "+id);
//        }
        Optional<Bus> optionalBus=busRepository.findById(id);
        if(optionalBus.isPresent())
        {
            return optionalBus.get();
        }
        else {
            throw new RuntimeException("Bus not found with the given Id : "+id);
        }
    }

    @Override
    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    @Override
    public String createBus(Bus bus) {
        Bus bus1=new Bus(bus.getId(),bus.getModel(),bus.getOrigin(),bus.getDestination(),bus.getDistance());
        busRepository.save(bus);
        return "Bus created successfully";
    }

    @Override
    public String updateBus(Bus updatedBusDetails) {
//        Optional<Bus> optionalBus=busList.stream()
//                .filter(b->b.getId().equals(id))
//                .findFirst();
//        if(optionalBus.isPresent())
//        {
//            Bus updatedBus=optionalBus.get();
//            updatedBus.setId(updatedBusDetails.getId());
//            updatedBus.setModel(updatedBusDetails.getModel());
//            updatedBus.setOrigin(updatedBusDetails.getOrigin());
//            updatedBus.setDestination(updatedBusDetails.getDestination());
//            updatedBus.setDistance(updatedBusDetails.getDistance());
//            return "Bus updated successfully "+updatedBus;
//        }
//        else {
//            throw new RuntimeException("Bus not found with the given Id : "+id);
//        }
//    }
        Optional<Bus> optionalBus=busRepository.findById(updatedBusDetails.getId());
        if(optionalBus.isPresent())
        {
            Bus updatedBus=optionalBus.get();
            updatedBus.setId(updatedBusDetails.getId());
            updatedBus.setModel(updatedBusDetails.getModel());
            updatedBus.setOrigin(updatedBusDetails.getOrigin());
            updatedBus.setDestination(updatedBusDetails.getDestination());
            updatedBus.setDistance(updatedBusDetails.getDistance());
            busRepository.save(updatedBus);
            return "Bus updated successfully "+updatedBus;
        }
        else {
            throw new RuntimeException("Bus not found with the given Id : "+updatedBusDetails.getId());
        }
    }

    @Override
    public String deleteBus(Integer id) {
//        Optional<Bus> optionalBus=busList.stream()
//                .filter(b->b.getId().equals(id))
//                .findFirst();
//        if(optionalBus.isPresent())
//        {
//            busList.remove(optionalBus.get());
//            return "Bus deleted successfully";
//        }
//        else {
//            throw new RuntimeException("Bus not found with the given Id : "+id);
//        }
        Optional<Bus> optionalBus=busRepository.findById(id);
        if(optionalBus.isPresent())
        {
            busRepository.delete(optionalBus.get());
            return "Bus deleted successfully";
        }
        else {
            throw new RuntimeException("Bus not found with the given Id : "+id);
        }
    }
}
