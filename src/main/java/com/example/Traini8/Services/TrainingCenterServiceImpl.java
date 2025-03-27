package com.example.Traini8.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Traini8.Dtos.TrainingCenterDto;
import com.example.Traini8.Entities.Address;
import com.example.Traini8.Entities.TrainingCenter;
import com.example.Traini8.Repositories.AddressRepository;
import com.example.Traini8.Repositories.TrainingCenterRepository;
import com.example.Traini8.ResponseDto.TrainingCenterResponse;

@Service
public class TrainingCenterServiceImpl implements TrainingCenterService {

    @Autowired
    private TrainingCenterRepository trainingCenterRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public TrainingCenterResponse createTrainingCenter(TrainingCenterDto trainingCenterDto) {
        try {
            Address savedAddress = addressRepository.save(trainingCenterDto.getAddress()); // Save Address first

            TrainingCenter trainingCenter = TrainingCenter.builder()
                    .centerName(trainingCenterDto.getCenterName())
                    .centerCode(trainingCenterDto.getCenterCode())
                    .address(savedAddress)  // Assign the saved Address
                    .studentCapacity(trainingCenterDto.getStudentCapacity())
                    .courses(trainingCenterDto.getCourses())
                    .contactEmail(trainingCenterDto.getContactEmail())
                    .contactPhoneNumber(trainingCenterDto.getContactPhoneNumber())
                    .build();
    
            TrainingCenter savedTrainingCenter = trainingCenterRepository.save(trainingCenter);
            return mapToResponse(savedTrainingCenter);

        } catch (Exception e) {
            throw new RuntimeException("Error creating training center", e);
        }
    }

    @Override
    public List<TrainingCenterResponse> getAllTrainingCenters() {
        try {
            List<TrainingCenter> centers = trainingCenterRepository.findAll();
            return centers.stream().map(this::mapToResponse).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error fetching training centers", e);
        }
    }

    private TrainingCenterResponse mapToResponse(TrainingCenter trainingCenter) {
        return TrainingCenterResponse.builder()
                .id(trainingCenter.getId())
                .centerName(trainingCenter.getCenterName())
                .centerCode(trainingCenter.getCenterCode())
                .address(trainingCenter.getAddress())
                .studentCapacity(trainingCenter.getStudentCapacity())
                .courses(trainingCenter.getCourses())
                .createdAt(trainingCenter.getCreatedAt())
                .contactEmail(trainingCenter.getContactEmail())
                .contactPhoneNumber(trainingCenter.getContactPhoneNumber())
                .build();
    }

}
