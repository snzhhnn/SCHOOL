package com.school.student_service.service;

import com.school.student_service.contract.ClassDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class ClassService {

    private final RestTemplate restTemplate;

    @Autowired
    public ClassService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ClassDTO getObjectFromRemoteService(UUID uuid) {
        String url = "http://localhost:8083/api/group/" + uuid;
        return restTemplate.getForObject(url, ClassDTO.class);
    }
}