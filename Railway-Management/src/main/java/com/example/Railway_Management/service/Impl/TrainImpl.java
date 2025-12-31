package com.example.Railway_Management.service.Impl;

import com.example.Railway_Management.dto.TrainDto;
import com.example.Railway_Management.entity.Train;
import com.example.Railway_Management.repository.TrainRepository;
import com.example.Railway_Management.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainImpl implements TrainService {
    @Autowired
    private TrainRepository repository;

    @Override
    public TrainDto createticket(TrainDto trainDto) {
        Train train=new Train(
                trainDto.getT_id(),
                trainDto.getT_no(),
                trainDto.getT_name(),
                trainDto.getT_distance(),
                trainDto.getT_price(),
                trainDto.getFrom_To()

        );
        Train savedticket=repository.save(train);
        TrainDto saveticket=new TrainDto(
                savedticket.getT_id(),
                savedticket.getT_no(),
                savedticket.getT_name(),
                savedticket.getT_distance(),
                savedticket.getT_price(),
                savedticket.getFrom_To()

        );
        return saveticket;
    }

    @Override
    public Train getticket(Long id) {
        return repository.findById(id)
                .orElseThrow(()->new RuntimeException("ticket not found with id "));
    }

    @Override
    public TrainDto updateticket(Long id, TrainDto trainDto) {
        Train train=repository.findById(id)
                .orElseThrow(()->new RuntimeException("ticket not found with the id"));
        train.setT_no(trainDto.getT_no());
        train.setT_name(trainDto.getT_name());
        train.setT_price(trainDto.getT_price());
        train.setT_distance(trainDto.getT_distance());
        train.setFrom_To(trainDto.getFrom_To());
        Train savedticket=repository.save(train);
        return new TrainDto(
                savedticket.getT_id(),
                savedticket.getT_no(),
                savedticket.getT_name(),
                savedticket.getT_distance(),
                savedticket.getT_price(),
                savedticket.getFrom_To()
        );
    }

    @Override
    public Train deleteticket(Long id) {
        Train t=repository.findById(id)
                .orElseThrow(()->new RuntimeException("ticket not found with id "));
        repository.delete(t);
        return t;
    }
}
