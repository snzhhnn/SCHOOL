package com.school.student_service.service;

import com.school.student_service.contract.EventDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface IEventService {
    CompletableFuture<EventDTO> getById(UUID id);
    CompletableFuture<EventDTO> save(EventDTO eventDTO);
    CompletableFuture<EventDTO> update(EventDTO eventDTO);
    void deleteById(UUID id);
    CompletableFuture<List<EventDTO>> findAll();
    CompletableFuture<List<EventDTO>> findAll(Pageable pageable);
}