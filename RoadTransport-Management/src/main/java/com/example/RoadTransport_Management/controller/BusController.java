package com.example.RoadTransport_Management.controller;

import com.example.RoadTransport_Management.dto.BusDto;
import com.example.RoadTransport_Management.service.Impl.BusImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bus")
public class BusController {
    @Autowired
    private BusImpl service;
    @PostMapping("/saveBus")
    public ResponseEntity<BusDto>createitemss(@RequestBody BusDto busDto){
        BusDto b=service.createticket(busDto);
        return new ResponseEntity<>(b, HttpStatus.CREATED);
    }
}
