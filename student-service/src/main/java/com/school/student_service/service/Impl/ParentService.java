package com.school.student_service.service.Impl;

import com.school.student_service.contract.ParentDTO;
import com.school.student_service.contract.StudentDTO;
import com.school.student_service.contract.mapper.ParentMapper;
import com.school.student_service.contract.mapper.StudentMapper;
import com.school.student_service.model.Parent;
import com.school.student_service.model.Student;
import com.school.student_service.repository.IParentRepository;
import com.school.student_service.repository.IStudentRepository;
import com.school.student_service.service.IParentService;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ParentService implements IParentService {

    private IStudentRepository studentRepo;


    private IParentRepository repo;

    @Override
    @Async
    public CompletableFuture<ParentDTO> getById(UUID id) {
        Parent parent = repo.getParentById(id);
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (UUID uuid: parent.getStudentsUUID()) {
            studentDTOS.add(StudentMapper.toDTO(studentRepo.getStudentById(uuid)));
        }
        ParentDTO parentDTO = ParentMapper.toDTO(parent);
        parentDTO.setStudentsDTO(studentDTOS);
        return CompletableFuture.completedFuture(parentDTO);
    }

    @Override
    @Async
    public CompletableFuture<ParentDTO> save(ParentDTO parentDTO) {
        Parent parent = ParentMapper.toEntity(parentDTO);
        List<UUID> studentUUIDs = parentDTO.getStudentsUUID();
        parent.setStudentsUUID(studentUUIDs);

        Parent savedParent = repo.save(parent);

        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (UUID uuid: savedParent.getStudentsUUID()) {
            studentDTOS.add(StudentMapper.toDTO(studentRepo.getStudentById(uuid)));
        }

        ParentDTO savedParentDTO = ParentMapper.toDTO(savedParent);
        savedParentDTO.setStudentsDTO(studentDTOS);
        return CompletableFuture.completedFuture(savedParentDTO);
    }

    @Override
    @Async
    public CompletableFuture<ParentDTO> update(ParentDTO parentDTO) {
        Parent parent = ParentMapper.toEntity(parentDTO);
        List<UUID> studentUUIDs = parentDTO.getStudentsUUID();
        parent.setStudentsUUID(studentUUIDs);

        Parent savedParent = repo.save(parent);

        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (UUID uuid: savedParent.getStudentsUUID()) {
            studentDTOS.add(StudentMapper.toDTO(studentRepo.getStudentById(uuid)));
        }

        ParentDTO savedParentDTO = ParentMapper.toDTO(savedParent);
        savedParentDTO.setStudentsDTO(studentDTOS);
        return CompletableFuture.completedFuture(savedParentDTO);
    }

    @Override
    @Async
    public void deleteById(UUID id) {
        repo.deleteById(id);
    }

    @Override
    @Async
    public CompletableFuture<List<ParentDTO>> findAll() {
        Iterable<Parent> parents = repo.findAll();
        List<ParentDTO> parentDTOS = new ArrayList<>();
        List<StudentDTO> studentDTOS = new ArrayList<>();
        parents.forEach(parent -> {
            for (UUID uuid: parent.getStudentsUUID()) {
                studentDTOS.add(StudentMapper.toDTO(studentRepo.getStudentById(uuid)));
            }
            ParentDTO parentDTO = ParentMapper.toDTO(parent);
            parentDTO.setStudentsDTO(studentDTOS);
            parentDTOS.add(parentDTO);
        });
        return CompletableFuture.completedFuture(parentDTOS);
    }


    @Override
    @Async
    public CompletableFuture<List<ParentDTO>> findAll(Pageable pageable) {
        Page<Parent> parents = repo.findAll(pageable);
        List<ParentDTO> parentDTOS = new ArrayList<>();
        List<StudentDTO> studentDTOS = new ArrayList<>();
        parents.forEach(parent -> {
            for (UUID uuid: parent.getStudentsUUID()) {
                studentDTOS.add(StudentMapper.toDTO(studentRepo.getStudentById(uuid)));
            }
            ParentDTO parentDTO = ParentMapper.toDTO(parent);
            parentDTO.setStudentsDTO(studentDTOS);
            parentDTOS.add(parentDTO);
        });
        return CompletableFuture.completedFuture(parentDTOS);
    }
}