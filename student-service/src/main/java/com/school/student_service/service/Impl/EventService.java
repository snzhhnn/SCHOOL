package com.school.student_service.service.Impl;

import com.school.student_service.contract.EventDTO;
import com.school.student_service.contract.StudentDTO;
import com.school.student_service.contract.mapper.EventMapper;
import com.school.student_service.contract.mapper.StudentMapper;
import com.school.student_service.model.Event;
import com.school.student_service.model.Student;
import com.school.student_service.repository.IEventRepository;
import com.school.student_service.repository.IStudentRepository;
import com.school.student_service.service.IEventService;
import com.school.student_service.service.IStudentService;
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

    private IStudentRepository studentRepo;

    @Override
    @Async
    public CompletableFuture<EventDTO> getById(UUID id) {
        Event event = repo.getEventById(id);
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (UUID uuid: event.getStudentUUID()) {
            studentDTOS.add(StudentMapper.toDTO(studentRepo.getStudentById(uuid)));
        }
        EventDTO eventDTO = EventMapper.toDTO(event);
        eventDTO.setStudentDTOS(studentDTOS);
        return CompletableFuture.completedFuture(eventDTO);
    }

    @Override
    @Async
    public CompletableFuture<EventDTO> save(EventDTO eventDTO) {
        Event event = EventMapper.toEntity(eventDTO);
        List<UUID> studentUUIDs = eventDTO.getStudentUUID();
        event.setStudentUUID(studentUUIDs);


        Event savedEvent = repo.save(event);

        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (UUID uuid : savedEvent.getStudentUUID()) {
            studentDTOS.add(StudentMapper.toDTO(studentRepo.getStudentById(uuid)));
        }

        EventDTO savedEventDTO = EventMapper.toDTO(savedEvent);
        savedEventDTO.setStudentDTOS(studentDTOS);
        return CompletableFuture.completedFuture(savedEventDTO);
    }

    @Override
    @Async
    public CompletableFuture<EventDTO> update(EventDTO eventDTO) {
        Event event = EventMapper.toEntity(eventDTO);
        List<UUID> studentUUIDs = eventDTO.getStudentUUID();
        event.setStudentUUID(studentUUIDs);


        Event savedEvent = repo.save(event);

        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (UUID uuid : savedEvent.getStudentUUID()) {
            studentDTOS.add(StudentMapper.toDTO(studentRepo.getStudentById(uuid)));
        }

        EventDTO savedEventDTO = EventMapper.toDTO(savedEvent);
        savedEventDTO.setStudentDTOS(studentDTOS);
        return CompletableFuture.completedFuture(savedEventDTO);
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
        List<StudentDTO> studentDTOS = new ArrayList<>();
        events.forEach(event -> {
            for (UUID uuid: event.getStudentUUID()) {
                studentDTOS.add(StudentMapper.toDTO(studentRepo.getStudentById(uuid)));
            }
            EventDTO dto = EventMapper.toDTO(event);
            dto.setStudentDTOS(studentDTOS);
            eventDTOS.add(dto);
        });
        return CompletableFuture.completedFuture(eventDTOS);
    }

    @Override
    @Async
    public CompletableFuture<List<EventDTO>> findAll(Pageable pageable) {
        Page<Event> events = repo.findAll(pageable);
        List<EventDTO> eventDTOS = new ArrayList<>();
        List<StudentDTO> studentDTOS = new ArrayList<>();
        events.forEach(event -> {
            for (UUID uuid: event.getStudentUUID()) {
                studentDTOS.add(StudentMapper.toDTO(studentRepo.getStudentById(uuid)));
            }
            EventDTO dto = EventMapper.toDTO(event);
            dto.setStudentDTOS(studentDTOS);
            eventDTOS.add(dto);
        });
        return CompletableFuture.completedFuture(eventDTOS);
    }
}