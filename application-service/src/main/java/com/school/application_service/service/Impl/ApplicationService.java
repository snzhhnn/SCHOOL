package com.school.application_service.service.Impl;

import com.school.application_service.contract.ApplicationDTO;
import com.school.application_service.contract.GroupDTO;
import com.school.application_service.contract.mapper.ApplicationMapper;
import com.school.application_service.contract.mapper.GroupMapper;
import com.school.application_service.model.Application;
import com.school.application_service.model.Group;
import com.school.application_service.repository.IApplicationRepository;
import com.school.application_service.repository.IGroupRepository;
import com.school.application_service.service.IApplicationService;
import com.school.application_service.service.IGroupService;
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
    private IGroupRepository groupRepository;

    @Override
    @Async
    public CompletableFuture<ApplicationDTO> getById(UUID id) {
        ApplicationDTO applicationDTO = ApplicationMapper.toDTO(repo.getApplicationById(id));
        Group group = groupRepository.getGroupById(applicationDTO.getGroupUUID());
        GroupDTO groupDTO = GroupMapper.toDTO(group);
        applicationDTO.setGroupDTO(groupDTO);
        return CompletableFuture.completedFuture(applicationDTO);
    }

    @Override
    @Async
    public CompletableFuture<ApplicationDTO> save(ApplicationDTO applicationDTO) {
        GroupDTO groupDTO = GroupMapper.toDTO(groupRepository.getGroupById(applicationDTO.getGroupUUID()));
        ApplicationDTO savedApplicationDTO = ApplicationMapper.toDTO(repo.save(ApplicationMapper.toEntity(applicationDTO)));
        savedApplicationDTO.setGroupDTO(groupDTO);
        return CompletableFuture.completedFuture(savedApplicationDTO);
    }

    @Override
    @Async
    public CompletableFuture<ApplicationDTO> update(ApplicationDTO applicationDTO) {
        GroupDTO groupDTO = GroupMapper.toDTO(groupRepository.getGroupById(applicationDTO.getGroupUUID()));
        ApplicationDTO savedApplicationDTO = ApplicationMapper.toDTO(repo.save(ApplicationMapper.toEntity(applicationDTO)));
        savedApplicationDTO.setGroupDTO(groupDTO);
        return CompletableFuture.completedFuture(savedApplicationDTO);
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
        applications.forEach(application -> {
            GroupDTO groupDTO = GroupMapper.toDTO(groupRepository.getGroupById(application.getIdGroup()));
            ApplicationDTO applicationDTO = ApplicationMapper.toDTO(application);
            applicationDTO.setGroupDTO(groupDTO);
            applicationDTOS.add(applicationDTO);
        });
        return CompletableFuture.completedFuture(applicationDTOS);
    }

    @Override
    @Async
    public CompletableFuture<List<ApplicationDTO>> findAll(Pageable pageable) {
        Page<Application> applications = repo.findAll(pageable);
        List<ApplicationDTO> applicationDTOS = new ArrayList<>();
        applications.forEach(application -> {
            GroupDTO groupDTO = GroupMapper.toDTO(groupRepository.getGroupById(application.getIdGroup()));
            ApplicationDTO applicationDTO = ApplicationMapper.toDTO(application);
            applicationDTO.setGroupDTO(groupDTO);
            applicationDTOS.add(applicationDTO);
        });
        return CompletableFuture.completedFuture(applicationDTOS);
    }
}