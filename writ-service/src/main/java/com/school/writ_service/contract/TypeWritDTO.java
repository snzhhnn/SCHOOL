package com.school.writ_service.contract;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class TypeWritDTO {
    private UUID id;
    private String title;
    private String description;
    private List<UUID> writsUUID;
}