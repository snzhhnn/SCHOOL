package com.school.recovery_service.service.Impl;

import com.school.recovery_service.contract.SanatoriumDTO;
import com.school.recovery_service.contract.mapper.SanatoriumMapper;
import com.school.recovery_service.model.Sanatorium;
import com.school.recovery_service.repository.ISanatoriumRepository;
import com.school.recovery_service.service.ISanatoriumService;
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
public class SanatoriumService implements ISanatoriumService {

    private ISanatoriumRepository repo;

    @Override
    @Async
    public CompletableFuture<SanatoriumDTO> getById(UUID id) {
        return CompletableFuture.completedFuture(SanatoriumMapper.toDTO(repo.getSanatoriumById(id)));
    }

    @Override
    @Async
    public CompletableFuture<SanatoriumDTO> save(SanatoriumDTO sanatoriumDTO) {
        return CompletableFuture.completedFuture(SanatoriumMapper.toDTO(repo.save(SanatoriumMapper.toEntity(sanatoriumDTO))));
    }

    @Override
    @Async
    public CompletableFuture<SanatoriumDTO> update(SanatoriumDTO sanatoriumDTO) {
        return CompletableFuture.completedFuture(SanatoriumMapper.toDTO(repo.save(SanatoriumMapper.toEntity(sanatoriumDTO))));
    }

    @Override
    @Async
    public void deleteById(UUID id) {
        repo.deleteById(id);
    }

    @Override
    @Async
    public CompletableFuture<List<SanatoriumDTO>> findAll() {
        Iterable<Sanatorium> sanatoriums = repo.findAll();
        List<SanatoriumDTO> sanatoriumDTOS = new ArrayList<>();
        sanatoriums.forEach(sanatorium -> sanatoriumDTOS.add(SanatoriumMapper.toDTO(sanatorium)));
        return CompletableFuture.completedFuture(sanatoriumDTOS);
    }

    @Override
    @Async
    public CompletableFuture<List<SanatoriumDTO>> findAll(Pageable pageable) {
        Page<Sanatorium> sanatoriums = repo.findAll(pageable);
        return CompletableFuture.completedFuture(sanatoriums.map(SanatoriumMapper::toDTO).getContent());
    }
}