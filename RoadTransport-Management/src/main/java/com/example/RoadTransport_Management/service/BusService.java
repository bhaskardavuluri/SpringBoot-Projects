package com.example.RoadTransport_Management.service;

import com.example.RoadTransport_Management.dto.BusDto;
import com.example.RoadTransport_Management.entity.Bus;

public interface BusService {
    BusDto createticket(BusDto busDto);
    Bus getticket(Long id );
    BusDto updateticket(Long id,BusDto busDto);
    Bus deleteticket(Long id);
}
