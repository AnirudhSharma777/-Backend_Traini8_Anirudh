package com.example.Traini8.Entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class TrainingCenter {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String centerName;

    private String centerCode;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    private Integer studentCapacity;

    private String[] courses;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @Column(
        nullable = false
    )
    private String contactEmail;

    private String contactPhoneNumber;
    

}
