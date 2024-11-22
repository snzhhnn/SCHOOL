package com.school.student_service.service.Impl;

import com.school.student_service.contract.StudentDTO;
import com.school.student_service.contract.mapper.StudentMapper;
import com.school.student_service.model.Student;
import com.school.student_service.repository.IStudentRepository;
import com.school.student_service.service.IStudentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
public class StudentService implements IStudentService {

    private IStudentRepository repo;

    @Override
    @Async
    public CompletableFuture<StudentDTO> getById(UUID id) {
        return CompletableFuture.completedFuture(StudentMapper.toDTO(repo.getStudentById(id)));
    }

    @Override
    @Async
    public CompletableFuture<StudentDTO> save(StudentDTO studentDTO) {
        return CompletableFuture.completedFuture(StudentMapper.toDTO(repo.save(StudentMapper.toEntity(studentDTO))));
    }

    @Override
    @Async
    public CompletableFuture<StudentDTO> update(StudentDTO studentDTO) {
        return CompletableFuture.completedFuture(StudentMapper.toDTO(repo.save(StudentMapper.toEntity(studentDTO))));
    }

    @Override
    @Async
    public void deleteById(UUID id) {
        repo.deleteById(id);
    }

    @Override
    @Async
    public CompletableFuture<List<StudentDTO>> findAll() {
        Iterable<Student> students = repo.findAll();
        List<StudentDTO> studentDTOS = new ArrayList<>();
        students.forEach(student -> studentDTOS.add(StudentMapper.toDTO(student)));
        return CompletableFuture.completedFuture(studentDTOS);
    }

    @Override
    @Async
    public CompletableFuture<List<StudentDTO>> findAll(Pageable pageable) {
        Page<Student> students = repo.findAll(pageable);
        return CompletableFuture.completedFuture(students.map(StudentMapper::toDTO).getContent());
    }
}