package com.example.Traini8.ResponseDto;

import java.time.LocalDateTime;

import com.example.Traini8.Entities.Address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainingCenterResponse {

    private String id;
    private String centerName;
    private String centerCode;
    private Address address;
    private Integer studentCapacity;
    private String[] courses;
    private LocalDateTime createdAt;
    private String contactEmail;
    private String contactPhoneNumber;

}