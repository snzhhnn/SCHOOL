package com.school.recovery_service.service.Impl;

import com.school.recovery_service.configuration.RestTemplateConfig;
import com.school.recovery_service.contract.RecoveryDTO;
import com.school.recovery_service.contract.StudentDTO;
import com.school.recovery_service.contract.mapper.RecoveryMapper;
import com.school.recovery_service.model.Recovery;
import com.school.recovery_service.repository.IRecoveryRepository;
import com.school.recovery_service.service.IRecoveryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
public class RecoveryService implements IRecoveryService {

    private IRecoveryRepository repo;

    @Override
    @Async
    public CompletableFuture<RecoveryDTO> getById(UUID id) {
        return CompletableFuture.completedFuture(RecoveryMapper.toDTO(repo.getRecoveryById(id)));
    }

    @Override
    @Async
    public CompletableFuture<RecoveryDTO> save(RecoveryDTO recoveryDTO) {
        StudentDTO studentDTO = StudentDTO.builder()
                .id(recoveryDTO.getIdStudent())
                .sanatoriumCurrentYear(true)
                .build();
        StudentService studentService = new StudentService(new RestTemplate());
        studentService.updateStudent(studentDTO);
        return CompletableFuture.completedFuture(RecoveryMapper.toDTO(repo.save(RecoveryMapper.toEntity(recoveryDTO))));
    }

    @Override
    @Async
    public CompletableFuture<RecoveryDTO> update(RecoveryDTO recoveryDTO) {
        return CompletableFuture.completedFuture(RecoveryMapper.toDTO(repo.save(RecoveryMapper.toEntity(recoveryDTO))));
    }

    @Override
    @Async
    public void deleteById(UUID id) {
        repo.deleteById(id);
    }

    @Override
    @Async
    public CompletableFuture<List<RecoveryDTO>> findAll() {
        Iterable<Recovery> recoveries = repo.findAll();
        List<RecoveryDTO> recoveryDTOS = new ArrayList<>();
        recoveries.forEach(recovery -> recoveryDTOS.add(RecoveryMapper.toDTO(recovery)));
        return CompletableFuture.completedFuture(recoveryDTOS);
    }


    @Override
    @Async
    public CompletableFuture<List<RecoveryDTO>> findAll(Pageable pageable) {
        Page<Recovery> recoveries = repo.findAll(pageable);
        return CompletableFuture.completedFuture(recoveries.map(RecoveryMapper::toDTO).getContent());
    }
}