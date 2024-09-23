package com.example.demo2.service;

import com.example.demo2.model.Bus;

import java.util.List;

public interface IBusService
{
    Bus getBus(Integer id);
    List<Bus> getAllBuses();
    String createBus(Bus bus);
    String updateBus(Bus updatedBusDetails);
    String deleteBus(Integer id);

}
