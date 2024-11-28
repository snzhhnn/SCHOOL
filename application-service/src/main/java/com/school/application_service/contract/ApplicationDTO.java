package com.school.application_service.contract;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class ApplicationDTO {
    private UUID id;
    private LocalDate date;
    private int countExtendedDay;
    private int countDiet;
    private int totalCount;
    private UUID groupUUID;
    private GroupDTO groupDTO;
}