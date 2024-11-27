package com.school.writ_service.model;

import com.school.writ_service.contract.StudentDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "writ")
@Entity
public class Writ {
    @Id
    @GeneratedValue
    private UUID id;
    private LocalDate date;
    @ElementCollection
    @CollectionTable(name = "student_dtos", joinColumns = @JoinColumn(name = "writ_id"))
    List<UUID> studentDTOS;

    @ManyToOne
    private TypeWrit typeWrit;
}