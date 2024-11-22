package com.school.student_service.service.Impl;

import com.school.student_service.contract.EventDTO;
import com.school.student_service.contract.mapper.EventMapper;
import com.school.student_service.model.Event;
import com.school.student_service.repository.IEventRepository;
import com.school.student_service.service.IEventService;
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
public class EventService implements IEventService {

    private IEventRepository repo;

    @Override
    @Async
    public CompletableFuture<EventDTO> getById(UUID id) {
        return CompletableFuture.completedFuture(EventMapper.toDTO(repo.getEventById(id)));
    }

    @Override
    @Async
    public CompletableFuture<EventDTO> save(EventDTO eventDTO) {
        return CompletableFuture.completedFuture(EventMapper.toDTO(repo.save(EventMapper.toEntity(eventDTO))));
    }

    @Override
    @Async
    public CompletableFuture<EventDTO> update(EventDTO eventDTO) {
        return CompletableFuture.completedFuture(EventMapper.toDTO(repo.save(EventMapper.toEntity(eventDTO))));
    }

    @Override
    @Async
    public void deleteById(UUID id) {
        repo.deleteById(id);
    }

    @Override
    @Async
    public CompletableFuture<List<EventDTO>> findAll() {
        Iterable<Event> events = repo.findAll();
        List<EventDTO> eventDTOS = new ArrayList<>();
        events.forEach(event -> eventDTOS.add(EventMapper.toDTO(event)));
        return CompletableFuture.completedFuture(eventDTOS);
    }

    @Override
    @Async
    public CompletableFuture<List<EventDTO>> findAll(Pageable pageable) {
        Page<Event> events = repo.findAll(pageable);
        return CompletableFuture.completedFuture(events.map(EventMapper::toDTO).getContent());
    }
}