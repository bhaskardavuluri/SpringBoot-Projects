package com.example.RoadTransport_Management.controller;

import com.example.RoadTransport_Management.dto.BusDto;
import com.example.RoadTransport_Management.entity.Bus;
import com.example.RoadTransport_Management.service.Impl.BusImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{id}")
    public ResponseEntity<Bus>gettickets(@PathVariable Long id){
        Bus b=service.getticket(id);
        return new ResponseEntity<>(b,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<BusDto>updatetickets(@PathVariable Long id ,@RequestBody BusDto busDto){
        BusDto b=service.updateticket(id,busDto);
        return new ResponseEntity<>(b,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deletetickets(@PathVariable Long id ){
        service.deleteticket(id);
        return ResponseEntity.ok("ticket deleted successfully");
    }
}
