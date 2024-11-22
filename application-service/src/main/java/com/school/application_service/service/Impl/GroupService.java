package com.school.application_service.service.Impl;

import com.school.application_service.contract.GroupDTO;
import com.school.application_service.contract.mapper.GroupMapper;
import com.school.application_service.model.Group;
import com.school.application_service.repository.IGroupRepository;
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
public class GroupService implements IGroupService {

    private IGroupRepository repo;

    @Override
    @Async
    public CompletableFuture<GroupDTO> getById(UUID id) {
        return CompletableFuture.completedFuture(GroupMapper.toDTO(repo.getGroupById(id)));
    }

    @Override
    @Async
    public CompletableFuture<GroupDTO> save(GroupDTO groupDTO) {
        return CompletableFuture.completedFuture(GroupMapper.toDTO(repo.save(GroupMapper.toEntity(groupDTO))));
    }

    @Override
    @Async
    public CompletableFuture<GroupDTO> update(GroupDTO groupDTO) {
        return CompletableFuture.completedFuture(GroupMapper.toDTO(repo.save(GroupMapper.toEntity(groupDTO))));
    }

    @Override
    @Async
    public void deleteById(UUID id) {
        repo.deleteById(id);
    }

    @Override
    @Async
    public CompletableFuture<List<GroupDTO>> findAll() {
        Iterable<Group> groups = repo.findAll();
        List<GroupDTO> groupDTOS = new ArrayList<>();
        groups.forEach(group -> groupDTOS.add(GroupMapper.toDTO(group)));
        return CompletableFuture.completedFuture(groupDTOS);
    }

    @Override
    @Async
    public CompletableFuture<List<GroupDTO>> findAll(Pageable pageable) {
        Page<Group> groups = repo.findAll(pageable);
        return CompletableFuture.completedFuture(groups.map(GroupMapper::toDTO).getContent());
    }
}