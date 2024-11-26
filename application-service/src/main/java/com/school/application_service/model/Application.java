package com.school.application_service.model;

import jakarta.persistence.*;
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

    @ManyToOne(cascade = CascadeType.ALL)
    private Group group;
}