package com.school.application_service.service;

import com.school.application_service.contract.ApplicationDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface IApplicationService {
    CompletableFuture<ApplicationDTO> getById(UUID id);
    CompletableFuture<ApplicationDTO> save(ApplicationDTO applicationDTO);
    CompletableFuture<ApplicationDTO> update(ApplicationDTO applicationDTO);
    void deleteById(UUID id);
    CompletableFuture<List<ApplicationDTO>> findAll();
    CompletableFuture<List<ApplicationDTO>> findAll(Pageable pageable);
}