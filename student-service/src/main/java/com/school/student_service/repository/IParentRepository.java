package com.school.student_service.repository;

import com.school.student_service.model.Parent;
import com.school.student_service.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IParentRepository extends CrudRepository<Parent, UUID>, PagingAndSortingRepository<Parent, UUID> {
    Parent getParentById(UUID id);
}