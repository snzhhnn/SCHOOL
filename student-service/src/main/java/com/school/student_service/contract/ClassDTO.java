package com.school.student_service.contract;

import lombok.Data;

import java.util.UUID;

@Data
public class ClassDTO {
    private UUID id;
    private int number;
    private char letter;
}