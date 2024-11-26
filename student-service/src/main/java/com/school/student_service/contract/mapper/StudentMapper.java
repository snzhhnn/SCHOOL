package com.school.student_service.contract.mapper;

import com.school.student_service.contract.ClassDTO;
import com.school.student_service.contract.StudentDTO;
import com.school.student_service.model.Student;
import com.school.student_service.service.Impl.ClassService;
import org.springframework.web.client.RestTemplate;

public class StudentMapper {

    public static Student toEntity(StudentDTO studentDTO) {
        return Student.builder()
                .id(studentDTO.getId())
                .lastname(studentDTO.getLastname())
                .firstname(studentDTO.getFirstname())
                .surname(studentDTO.getSurname())
                .birthdate(studentDTO.getBirthdate())
                .phone(studentDTO.getPhone())
                .registrationStreet(studentDTO.getRegistrationStreet())
                .registrationHouse(studentDTO.getRegistrationHouse())
                .registrationApartment(studentDTO.getRegistrationApartment())
                .residentialStreet(studentDTO.getResidentialStreet())
                .residentialHouse(studentDTO.getResidentialHouse())
                .residentialApartment(studentDTO.getResidentialApartment())
                .dateOfEnrollment(studentDTO.getDateOfEnrollment())
                .pioneerOrganization(studentDTO.getPioneerOrganization())
                .familyStatus(studentDTO.getFamilyStatus())
                .sanatoriumCurrentYear(studentDTO.getSanatoriumCurrentYear())
                .idClass(studentDTO.getIdClass())
                .parents(studentDTO.getParents())
                .events(studentDTO.getEvents())
                .build();
    }

    public static StudentDTO toDTO(Student student) {
        ClassService classService = new ClassService(new RestTemplate());
        ClassDTO classDTO = classService.getObjectFromRemoteService(student.getIdClass());
        return StudentDTO.builder()
                .id(student.getId())
                .lastname(student.getLastname())
                .firstname(student.getFirstname())
                .surname(student.getSurname())
                .birthdate(student.getBirthdate())
                .phone(student.getPhone())
                .registrationStreet(student.getRegistrationStreet())
                .registrationHouse(student.getRegistrationHouse())
                .registrationApartment(student.getRegistrationApartment())
                .residentialStreet(student.getResidentialStreet())
                .residentialHouse(student.getResidentialHouse())
                .residentialApartment(student.getResidentialApartment())
                .dateOfEnrollment(student.getDateOfEnrollment())
                .pioneerOrganization(student.getPioneerOrganization())
                .familyStatus(student.getFamilyStatus())
                .sanatoriumCurrentYear(student.getSanatoriumCurrentYear())
                .idClass(student.getIdClass())
                .parents(student.getParents())
                .events(student.getEvents())
                .classDTO(classDTO)
                .build();
    }
}