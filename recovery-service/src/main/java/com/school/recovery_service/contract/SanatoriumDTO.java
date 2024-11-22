package com.school.recovery_service.contract;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class SanatoriumDTO {
    private UUID id;
    private String title;
    private String city;
}