package com.school.student_service.contract.mapper;

import com.school.student_service.contract.EventDTO;
import com.school.student_service.model.Event;


public class EventMapper {
    public static Event toEntity(EventDTO eventDTO) {
        return Event.builder()
                .id(eventDTO.getId())
                .title(eventDTO.getTitle())
                .date(eventDTO.getDate())
                .studentUUID(eventDTO.getStudentUUID())
                .build();
    }

    public static EventDTO toDTO(Event event) {
        return EventDTO.builder()
                .id(event.getId())
                .title(event.getTitle())
                .date(event.getDate())
                .studentUUID(event.getStudentUUID())
                .build();
    }
}