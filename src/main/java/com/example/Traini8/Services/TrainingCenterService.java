package com.example.Traini8.Services;

import java.util.List;

import com.example.Traini8.Dtos.TrainingCenterDto;
import com.example.Traini8.ResponseDto.TrainingCenterResponse;

public interface TrainingCenterService {

    TrainingCenterResponse createTrainingCenter(TrainingCenterDto trainingCenter);
    List<TrainingCenterResponse> getAllTrainingCenters();

}
