package com.school.writ_service.service.Impl;

import com.school.writ_service.contract.TypeWritDTO;
import com.school.writ_service.contract.mapper.TypeWritMapper;
import com.school.writ_service.model.TypeWrit;
import com.school.writ_service.repository.ITypeWritRepository;
import com.school.writ_service.service.ITypeWritService;
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
public class TypeWritService implements ITypeWritService {

    private ITypeWritRepository repo;

    @Override
    @Async
    public CompletableFuture<TypeWritDTO> getById(UUID id) {
        return CompletableFuture.completedFuture(TypeWritMapper.toDTO(repo.getTypeWritById(id)));
    }

    @Override
    @Async
    public CompletableFuture<TypeWritDTO> save(TypeWritDTO typeWritDTO) {
        return CompletableFuture.completedFuture(TypeWritMapper.toDTO(repo.save(TypeWritMapper.toEntity(typeWritDTO))));
    }

    @Override
    @Async
    public CompletableFuture<TypeWritDTO> update(TypeWritDTO typeWritDTO) {
        return CompletableFuture.completedFuture(TypeWritMapper.toDTO(repo.save(TypeWritMapper.toEntity(typeWritDTO))));
    }

    @Override
    @Async
    public void deleteById(UUID id) {
        repo.deleteById(id);
    }

    @Override
    @Async
    public CompletableFuture<List<TypeWritDTO>> findAll() {
        Iterable<TypeWrit> typeWrits = repo.findAll();
        List<TypeWritDTO> typeWritDTOS = new ArrayList<>();
        typeWrits.forEach(typeWrit -> typeWritDTOS.add(TypeWritMapper.toDTO(typeWrit)));
        return CompletableFuture.completedFuture(typeWritDTOS);
    }

    @Override
    @Async
    public CompletableFuture<List<TypeWritDTO>> findAll(Pageable pageable) {
        Page<TypeWrit> typeWrits = repo.findAll(pageable);
        return CompletableFuture.completedFuture(typeWrits.map(TypeWritMapper::toDTO).getContent());
    }
}
