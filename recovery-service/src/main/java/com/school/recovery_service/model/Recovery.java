package com.school.recovery_service.model;

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
@Table(name = "recovery")
@Entity
public class Recovery {
    @Id
    @GeneratedValue
    private UUID id;
    private LocalDate startDate;
    private LocalDate endDate;
    private UUID idStudent;

    @ManyToOne
    private Sanatorium sanatorium;
}