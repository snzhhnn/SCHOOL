package com.school.recovery_service.contract;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class RecoveryDTO {
    private UUID id;
    private LocalDate startDate;
    private LocalDate endDate;
    private UUID idStudent;
    private UUID idSanatorium;
}