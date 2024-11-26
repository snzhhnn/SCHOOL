package com.school.student_service.contract.mapper;

import com.school.student_service.contract.ParentDTO;
import com.school.student_service.model.Parent;
import com.school.student_service.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ParentMapper {

    public static Parent toEntity(ParentDTO parentDTO) {
        List<Student> students = new ArrayList<>();
        System.out.println("size" + parentDTO.getStudentsUUID().size());
        if (parentDTO.getStudentsUUID() != null) {
            students = parentDTO.getStudentsUUID()
                    .stream()
                    .map((id) -> Student.builder().id(id).build())
                    .collect(Collectors.toList());
        }
        return Parent.builder()
                .id(parentDTO.getId())
                .lastname(parentDTO.getLastname())
                .firstname(parentDTO.getFirstname())
                .surname(parentDTO.getSurname())
                .phone(parentDTO.getPhone())
                .workAddress(parentDTO.getWorkAddress())
                .students(students)
                .build();
    }

    public static ParentDTO toDTO(Parent parent) {
        List<UUID> studentIds = new ArrayList<>();
        System.out.println("size" + parent.getStudents().size());
        if (parent.getStudents() != null) {
             studentIds = parent.getStudents()
                    .stream()
                    .map(Student::getId)
                    .toList();
        }
        return ParentDTO.builder()
                .id(parent.getId())
                .lastname(parent.getLastname())
                .firstname(parent.getFirstname())
                .surname(parent.getSurname())
                .phone(parent.getPhone())
                .workAddress(parent.getWorkAddress())
                .studentsUUID(studentIds)
                .build();
    }
}