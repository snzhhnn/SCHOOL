package com.school.student_service.model;

import jakarta.persistence.*;
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
@Table(name = "parent")
@Entity
public class Parent {
    @Id
    @GeneratedValue
    private UUID id;
    private String lastname;
    private String firstname;
    private String surname;
    private String phone;
    private String workAddress;

    @ElementCollection
    @CollectionTable(name = "student_uuid_parent", joinColumns = @JoinColumn(name = "student_id"))
    private List<UUID> studentsUUID;

    @ManyToMany(cascade = CascadeType.MERGE)
    private List<Student> students;
}