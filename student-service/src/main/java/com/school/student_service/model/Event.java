package com.school.student_service.model;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToMany;
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
@Table(name = "student")
@Entity
public class Event {
    @Id
    @GeneratedValue
    private UUID id;
    private String title;
    private LocalDate date;

    @ManyToMany(mappedBy = "events")
    private List<Student> students;
}
