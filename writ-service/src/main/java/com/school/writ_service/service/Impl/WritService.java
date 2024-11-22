package com.school.writ_service.service.Impl;

import com.school.writ_service.contract.WritDTO;
import com.school.writ_service.contract.mapper.WritMapper;
import com.school.writ_service.model.Writ;
import com.school.writ_service.repository.IWritRepository;
import com.school.writ_service.service.IWritService;
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
public class WritService implements IWritService {

    private IWritRepository repo;

    @Override
    @Async
    public CompletableFuture<WritDTO> getById(UUID id) {
        return CompletableFuture.completedFuture(WritMapper.toDTO(repo.getWritById(id)));
    }

    @Override
    @Async
    public CompletableFuture<WritDTO> save(WritDTO writDTO) {
        return CompletableFuture.completedFuture(WritMapper.toDTO(repo.save(WritMapper.toEntity(writDTO))));
    }

    @Override
    @Async
    public CompletableFuture<WritDTO> update(WritDTO writDTO) {
        return CompletableFuture.completedFuture(WritMapper.toDTO(repo.save(WritMapper.toEntity(writDTO))));
    }

    @Override
    @Async
    public void deleteById(UUID id) {
        repo.deleteById(id);
    }

    @Override
    @Async
    public CompletableFuture<List<WritDTO>> findAll() {
        Iterable<Writ> writs = repo.findAll();
        List<WritDTO> writDTOS = new ArrayList<>();
        writs.forEach(writ -> writDTOS.add(WritMapper.toDTO(writ)));
        return CompletableFuture.completedFuture(writDTOS);
    }

    @Override
    @Async
    public CompletableFuture<List<WritDTO>> findAll(Pageable pageable) {
        Page<Writ> writs = repo.findAll(pageable);
        return CompletableFuture.completedFuture(writs.map(WritMapper::toDTO).getContent());
    }
}