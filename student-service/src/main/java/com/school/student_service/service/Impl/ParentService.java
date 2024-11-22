package com.school.student_service.service.Impl;

import com.school.student_service.contract.ParentDTO;
import com.school.student_service.contract.mapper.ParentMapper;
import com.school.student_service.model.Parent;
import com.school.student_service.repository.IParentRepository;
import com.school.student_service.service.IParentService;
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
public class ParentService implements IParentService {

    private IParentRepository repo;

    @Override
    @Async
    public CompletableFuture<ParentDTO> getById(UUID id) {
        return CompletableFuture.completedFuture(ParentMapper.toDTO(repo.getParentById(id)));
    }

    @Override
    @Async
    public CompletableFuture<ParentDTO> save(ParentDTO parentDTO) {
        return CompletableFuture.completedFuture(ParentMapper.toDTO(repo.save(ParentMapper.toEntity(parentDTO))));
    }

    @Override
    @Async
    public CompletableFuture<ParentDTO> update(ParentDTO parentDTO) {
        return CompletableFuture.completedFuture(ParentMapper.toDTO(repo.save(ParentMapper.toEntity(parentDTO))));
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
        parents.forEach(parent -> parentDTOS.add(ParentMapper.toDTO(parent)));
        return CompletableFuture.completedFuture(parentDTOS);
    }


    @Override
    @Async
    public CompletableFuture<List<ParentDTO>> findAll(Pageable pageable) {
        Page<Parent> parents = repo.findAll(pageable);
        return CompletableFuture.completedFuture(parents.map(ParentMapper::toDTO).getContent());
    }
}