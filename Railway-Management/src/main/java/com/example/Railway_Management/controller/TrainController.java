package com.example.Railway_Management.controller;

import com.example.Railway_Management.dto.TrainDto;
import com.example.Railway_Management.entity.Train;
import com.example.Railway_Management.service.Impl.TrainImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/train")
public class TrainController {
    @Autowired
    private TrainImpl service;
    @PostMapping("/saveTrain")
    public ResponseEntity<TrainDto>createtickets(@RequestBody TrainDto trainDto){
        TrainDto t=service.createticket(trainDto);
        return new ResponseEntity<>(t, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Train>gettickets(@PathVariable Long id ){
        Train t=service.getticket(id);
        return new ResponseEntity<>(t,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TrainDto>updatetickets(@PathVariable Long id ,@RequestBody TrainDto trainDto){
        TrainDto t=service.updateticket(id,trainDto);
        return  new ResponseEntity<>(t,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deletetickets(@PathVariable Long id ){
        service.deleteticket(id);
        return ResponseEntity.ok("Ticket deleted successfully");
    }
}
