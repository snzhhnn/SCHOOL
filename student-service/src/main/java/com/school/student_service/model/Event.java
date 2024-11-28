package com.school.student_service.model;

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
@Table(name = "event")
@Entity
public class Event {
    @Id
    @GeneratedValue
    private UUID id;
    private String title;
    private LocalDate date;

    @ElementCollection
    @CollectionTable(name = "student_save", joinColumns = @JoinColumn(name = "event_id"))
    private List<UUID> studentUUID;

    @ManyToMany(mappedBy = "events")
    private List<Student> students;
}