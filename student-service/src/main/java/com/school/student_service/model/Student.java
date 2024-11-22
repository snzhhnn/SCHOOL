package com.school.student_service.model;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;
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
public class Student {
    @Id
    @GeneratedValue
    private UUID id;
    private String lastname;
    private String firstname;
    private String surname;
    private LocalDate birthdate;
    private String phone;
    private String registrationStreet;
    private String registrationHouse;
    private String registrationApartment;
    private String residentialStreet;
    private String residentialHouse;
    private String residentialApartment;
    private String dateOfEnrollment;
    private String pioneerOrganization;
    @ElementCollection
    @CollectionTable(name = "student_family_status", joinColumns = @JoinColumn(name = "student_id"))
    private List<String> familyStatus;
    private Boolean sanatoriumCurrentYear;
    private UUID idClass;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Parent> parents;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Event> events;
}