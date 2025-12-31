package com.example.RoadTransport_Management.service.Impl;

import com.example.RoadTransport_Management.dto.BusDto;
import com.example.RoadTransport_Management.entity.Bus;
import com.example.RoadTransport_Management.repository.BusRepository;
import com.example.RoadTransport_Management.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusImpl implements BusService {
    @Autowired
    private BusRepository repository;

    @Override
    public BusDto createticket(BusDto busDto) {
        Bus bus=new Bus(
                busDto.getId(),
                busDto.getPlace(),
                busDto.getType(),
                busDto.getDistance(),
                busDto.getPrice()
        );
        Bus savedticket=repository.save(bus);
        BusDto saveticket=new BusDto(
                savedticket.getId(),
                savedticket.getPlace(),
                savedticket.getType(),
                savedticket.getDistance(),
                savedticket.getPrice()
        );
        return saveticket;
    }
}
