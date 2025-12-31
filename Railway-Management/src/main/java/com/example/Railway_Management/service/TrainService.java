package com.example.Railway_Management.service;

import com.example.Railway_Management.dto.TrainDto;
import com.example.Railway_Management.entity.Train;

public interface TrainService {
    TrainDto  createticket(TrainDto trainDto);
    Train getticket(Long id );
    TrainDto updateticket(Long id ,TrainDto trainDto);
    Train deleteticket(Long id);
}
