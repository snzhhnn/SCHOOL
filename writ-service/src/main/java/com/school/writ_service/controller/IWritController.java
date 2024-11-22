package com.school.writ_service.controller;

import com.school.writ_service.contract.WritDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface IWritController {
    CompletableFuture<WritDTO> getById(UUID id);
    CompletableFuture<WritDTO> save(WritDTO writDTO);
    CompletableFuture<WritDTO> update(WritDTO writDTO);
    void deleteById(UUID id);
    CompletableFuture<List<WritDTO>> findAll();
    CompletableFuture<List<WritDTO>> findAll(Pageable pageable);
}
