package com.example.Traini8.Controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Traini8.Dtos.TrainingCenterDto;
import com.example.Traini8.ResponseDto.TrainingCenterResponse;
import com.example.Traini8.Services.TrainingCenterServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/training-centers")
public class TrainingCenterController {

    @Autowired
    private TrainingCenterServiceImpl trainingCenterService;
    
    @PostMapping
    public ResponseEntity<TrainingCenterResponse> createTrainingCenter(@Valid @RequestBody TrainingCenterDto trainingCenter) {
        TrainingCenterResponse response = trainingCenterService.createTrainingCenter(trainingCenter);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);       
    }
    
    @GetMapping
    public ResponseEntity<List<TrainingCenterResponse>> getAllTrainingCenters() {
        List<TrainingCenterResponse> response = trainingCenterService.getAllTrainingCenters();
        return ResponseEntity.ok(response);      
    }

    // @ExceptionHandler(MethodArgumentNotValidException.class)
    // public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
    //     Map<String, String> errors = new HashMap<>();
    //     ex.getBindingResult().getFieldErrors().forEach(error ->
    //         errors.put(error.getField(), error.getDefaultMessage()));
    //     return ResponseEntity.badRequest().body(errors);
    // }

}
