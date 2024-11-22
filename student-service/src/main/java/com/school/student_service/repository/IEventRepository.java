package com.school.student_service.repository;

import com.school.student_service.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface IEventRepository extends CrudRepository<Event, UUID>, PagingAndSortingRepository<Event, UUID> {
    Event getEventById(UUID id);
}