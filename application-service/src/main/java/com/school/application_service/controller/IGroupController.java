package com.school.application_service.controller;

import com.school.application_service.contract.GroupDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface IGroupController {
    CompletableFuture<GroupDTO> getById(UUID id);
    CompletableFuture<GroupDTO> save(GroupDTO groupDTO);
    CompletableFuture<GroupDTO> update(GroupDTO groupDTO);
    void deleteById(UUID id);
    CompletableFuture<List<GroupDTO>> findAll();
    CompletableFuture<List<GroupDTO>> findAll(Pageable pageable);
}
