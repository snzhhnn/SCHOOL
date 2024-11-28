package com.school.student_service.contract;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class ParentDTO {
    private UUID id;
    private String lastname;
    private String firstname;
    private String surname;
    private String phone;
    private String workAddress;
    private List<UUID> studentsUUID;
    private List<StudentDTO> studentsDTO;
}