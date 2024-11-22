package com.school.application_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "class")
@Entity
public class Group {
    @Id
    @GeneratedValue
    private UUID id;
    private int number;
    private char letter;

    @OneToMany(mappedBy = "group")
    private List<Application> applications;
}