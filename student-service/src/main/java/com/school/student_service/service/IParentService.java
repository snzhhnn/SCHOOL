package com.school.student_service.service;

import com.school.student_service.contract.ParentDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface IParentService {
    CompletableFuture<ParentDTO> getById(UUID id);
    CompletableFuture<ParentDTO> save(ParentDTO parentDTO);
    CompletableFuture<ParentDTO> update(ParentDTO parentDTO);
    void deleteById(UUID id);
    CompletableFuture<List<ParentDTO>> findAll();
    CompletableFuture<List<ParentDTO>> findAll(Pageable pageable);
}