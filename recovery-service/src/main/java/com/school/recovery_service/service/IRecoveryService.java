package com.school.recovery_service.service;

import com.school.recovery_service.contract.RecoveryDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface IRecoveryService {
    CompletableFuture<RecoveryDTO> getById(UUID id);
    CompletableFuture<RecoveryDTO> save(RecoveryDTO recoveryDTO);
    CompletableFuture<RecoveryDTO> update(RecoveryDTO recoveryDTO);
    void deleteById(UUID id);
    CompletableFuture<List<RecoveryDTO>> findAll();
    CompletableFuture<List<RecoveryDTO>> findAll(Pageable pageable);
}