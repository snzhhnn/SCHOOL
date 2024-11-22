package com.school.student_service.repository;

import com.school.student_service.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface IStudentRepository extends CrudRepository<Student, UUID>, PagingAndSortingRepository<Student, UUID> {
    Student getStudentById(UUID id);
}