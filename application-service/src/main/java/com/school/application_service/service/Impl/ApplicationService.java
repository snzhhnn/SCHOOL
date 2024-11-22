package com.school.application_service.service.Impl;

import com.school.application_service.contract.ApplicationDTO;
import com.school.application_service.contract.mapper.ApplicationMapper;
import com.school.application_service.model.Application;
import com.school.application_service.repository.IApplicationRepository;
import com.school.application_service.service.IApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
public class ApplicationService implements IApplicationService {

    private IApplicationRepository repo;

    @Override
    @Async
    public CompletableFuture<ApplicationDTO> getById(UUID id) {
        return CompletableFuture.completedFuture(ApplicationMapper.toDTO(repo.getApplicationById(id)));
    }

    @Override
    @Async
    public CompletableFuture<ApplicationDTO> save(ApplicationDTO applicationDTO) {
        return CompletableFuture.completedFuture(ApplicationMapper.toDTO(repo.save(ApplicationMapper.toEntity(applicationDTO))));
    }

    @Override
    @Async
    public CompletableFuture<ApplicationDTO> update(ApplicationDTO applicationDTO) {
        return CompletableFuture.completedFuture(ApplicationMapper.toDTO(repo.save(ApplicationMapper.toEntity(applicationDTO))));
    }

    @Override
    @Async
    public void deleteById(UUID id) {
        repo.deleteById(id);
    }

    @Override
    @Async
    public CompletableFuture<List<ApplicationDTO>> findAll() {
        Iterable<Application> applications = repo.findAll();
        List<ApplicationDTO> applicationDTOS = new ArrayList<>();
        applications.forEach(application -> applicationDTOS.add(ApplicationMapper.toDTO(application)));
        return CompletableFuture.completedFuture(applicationDTOS);
    }

    @Override
    @Async
    public CompletableFuture<List<ApplicationDTO>> findAll(Pageable pageable) {
        Page<Application> applications = repo.findAll(pageable);
        return CompletableFuture.completedFuture(applications.map(ApplicationMapper::toDTO).getContent());
    }
}