package com.school.application_service.contract;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class GroupDTO {
    private UUID id;
    private int number;
    private char letter;
}