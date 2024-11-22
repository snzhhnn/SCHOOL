package com.school.recovery_service.controller;

import com.school.recovery_service.contract.SanatoriumDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface ISanatoriumController {
    CompletableFuture<SanatoriumDTO> getById(UUID id);
    CompletableFuture<SanatoriumDTO> save(SanatoriumDTO sanatoriumDTO);
    CompletableFuture<SanatoriumDTO> update(SanatoriumDTO sanatoriumDTO);
    void deleteById(UUID id);
    CompletableFuture<List<SanatoriumDTO>> findAll();
    CompletableFuture<List<SanatoriumDTO>> findAll(Pageable pageable);
}