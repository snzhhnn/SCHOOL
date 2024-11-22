package com.school.student_service.model;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.CascadeType;
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

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Student> students;
}