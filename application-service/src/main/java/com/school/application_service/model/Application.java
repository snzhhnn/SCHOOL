package com.school.application_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "application")
@Entity
public class Application {
    @Id
    @GeneratedValue
    private UUID id;
    private LocalDate date;
    private int countExtendedDay;
    private int countDiet;
    private int totalCount;

    @ManyToOne
    private Group group;
}