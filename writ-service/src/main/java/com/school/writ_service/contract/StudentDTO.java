package com.school.writ_service.contract;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Builder
@Data
public class StudentDTO {
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
    private LocalDate dateOfEnrollment;
    private String pioneerOrganization;
    private List<String> familyStatus;
    private Boolean sanatoriumCurrentYear;
    private UUID idClass;
}