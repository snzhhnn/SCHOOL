package com.school.recovery_service.model;

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
@Table(name = "sanatorium")
@Entity
public class Sanatorium {
    @Id
    @GeneratedValue
    private UUID id;
    private String title;
    private String city;

    @OneToMany
    private List<Recovery> recoveries;
}