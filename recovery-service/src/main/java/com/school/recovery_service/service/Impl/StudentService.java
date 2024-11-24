package com.school.recovery_service.service.Impl;

import com.school.recovery_service.contract.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class StudentService {

    private final RestTemplate restTemplate;

    @Autowired
    public StudentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public StudentDTO getObjectFromRemoteService(UUID uuid) {
        String url = "http://localhost:8082/api/student/" + uuid;
        return restTemplate.getForObject(url, StudentDTO.class);
    }

    public void updateStudent(StudentDTO studentDTO) {
        String url = "http://localhost:8082/api/student/update";
        restTemplate.put(url, studentDTO);
    }
}