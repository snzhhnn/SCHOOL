package com.school.writ_service.contract;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class WritDTO {
    private UUID id;
    private LocalDate date;
    private UUID idTypeWrit;
    private List<UUID> studentUUID;
}