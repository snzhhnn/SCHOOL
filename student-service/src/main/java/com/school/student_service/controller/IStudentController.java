package com.school.student_service.controller;

import com.school.student_service.contract.StudentDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface IStudentController {
    CompletableFuture<StudentDTO> getById(UUID id);
    CompletableFuture<StudentDTO> save(StudentDTO studentDTO);
    CompletableFuture<StudentDTO> update(StudentDTO studentDTO);
    void deleteById(UUID id);
    CompletableFuture<List<StudentDTO>> findAll();
    CompletableFuture<List<StudentDTO>> findAll(Pageable pageable);
}