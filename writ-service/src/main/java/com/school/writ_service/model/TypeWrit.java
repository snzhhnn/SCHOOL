package com.school.writ_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
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
@Table(name = "type_writ")
@Entity
public class TypeWrit {
    @Id
    @GeneratedValue
    private UUID id;
    private String title;
    private String description;

    @OneToMany(mappedBy = "typeWrit")
    private List<Writ> writs;
}