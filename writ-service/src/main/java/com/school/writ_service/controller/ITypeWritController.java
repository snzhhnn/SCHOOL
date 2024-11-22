package com.school.writ_service.controller;

import com.school.writ_service.contract.TypeWritDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface ITypeWritController {
    CompletableFuture<TypeWritDTO> getById(UUID id);
    CompletableFuture<TypeWritDTO> save(TypeWritDTO typeWritDTO);
    CompletableFuture<TypeWritDTO> update(TypeWritDTO typeWritDTO);
    void deleteById(UUID id);
    CompletableFuture<List<TypeWritDTO>> findAll();
    CompletableFuture<List<TypeWritDTO>> findAll(Pageable pageable);
}