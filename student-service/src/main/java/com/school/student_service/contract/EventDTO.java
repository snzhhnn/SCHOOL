package com.school.student_service.contract;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class EventDTO {
    private UUID id;
    private String title;
    private LocalDate date;
    private List<UUID> studentUUID;
    private List<StudentDTO> studentDTOS;
}