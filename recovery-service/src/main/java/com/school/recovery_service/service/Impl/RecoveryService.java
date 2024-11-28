package com.school.recovery_service.service.Impl;

import com.school.recovery_service.contract.RecoveryDTO;
import com.school.recovery_service.contract.SanatoriumDTO;
import com.school.recovery_service.contract.StudentDTO;
import com.school.recovery_service.contract.mapper.RecoveryMapper;
import com.school.recovery_service.contract.mapper.SanatoriumMapper;
import com.school.recovery_service.model.Recovery;
import com.school.recovery_service.repository.IRecoveryRepository;
import com.school.recovery_service.repository.ISanatoriumRepository;
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
    private ISanatoriumRepository sanatoriumRepository;
    private StudentService studentService;

    @Override
    @Async
    public CompletableFuture<RecoveryDTO> getById(UUID id) {
        Recovery recovery = repo.getRecoveryById(id);
        StudentDTO studentDTO = studentService.getObjectFromRemoteService(recovery.getIdStudent());
        SanatoriumDTO sanatoriumDTO = SanatoriumMapper.toDTO(sanatoriumRepository.getSanatoriumById(recovery.getIdSanatorium()));
        RecoveryDTO recoveryDTO = RecoveryMapper.toDTO(recovery);
        recoveryDTO.setStudentDTO(studentDTO);
        recoveryDTO.setSanatoriumDTO(sanatoriumDTO);
        return CompletableFuture.completedFuture(recoveryDTO);
    }

    @Override
    @Async
    public CompletableFuture<RecoveryDTO> save(RecoveryDTO recoveryDTO) {
        RecoveryDTO savedRecovery = RecoveryMapper.toDTO(repo.save(RecoveryMapper.toEntity(recoveryDTO)));
        StudentService studentService = new StudentService(new RestTemplate());
        StudentDTO studentDTO = studentService.getObjectFromRemoteService(recoveryDTO.getIdStudent());
        SanatoriumDTO sanatoriumDTO = SanatoriumMapper.toDTO(sanatoriumRepository.getSanatoriumById(recoveryDTO.getIdSanatorium()));
        studentDTO.setSanatoriumCurrentYear(true);
        studentService.updateStudent(studentDTO);
        savedRecovery.setStudentDTO(studentDTO);
        savedRecovery.setSanatoriumDTO(sanatoriumDTO);
        return CompletableFuture.completedFuture(savedRecovery);
    }

    @Override
    @Async
    public CompletableFuture<RecoveryDTO> update(RecoveryDTO recoveryDTO) {
        RecoveryDTO savedRecovery = RecoveryMapper.toDTO(repo.save(RecoveryMapper.toEntity(recoveryDTO)));
        studentService = new StudentService(new RestTemplate());
        StudentDTO studentDTO = studentService.getObjectFromRemoteService(recoveryDTO.getIdStudent());
        SanatoriumDTO sanatoriumDTO = SanatoriumMapper.toDTO(sanatoriumRepository.getSanatoriumById(recoveryDTO.getIdSanatorium()));
        studentDTO.setSanatoriumCurrentYear(true);
        studentService.updateStudent(studentDTO);
        savedRecovery.setStudentDTO(studentDTO);
        savedRecovery.setSanatoriumDTO(sanatoriumDTO);
        return CompletableFuture.completedFuture(savedRecovery);
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
        recoveries.forEach(recovery -> {
            StudentDTO studentDTO = studentService.getObjectFromRemoteService(recovery.getIdStudent());
            SanatoriumDTO sanatoriumDTO = SanatoriumMapper.toDTO(sanatoriumRepository.getSanatoriumById(recovery.getIdSanatorium()));
            RecoveryDTO recoveryDTO = RecoveryMapper.toDTO(recovery);
            recoveryDTO.setStudentDTO(studentDTO);
            recoveryDTO.setSanatoriumDTO(sanatoriumDTO);
            recoveryDTOS.add(recoveryDTO);
        });
        return CompletableFuture.completedFuture(recoveryDTOS);
    }


    @Override
    @Async
    public CompletableFuture<List<RecoveryDTO>> findAll(Pageable pageable) {
        Page<Recovery> recoveries = repo.findAll(pageable);
        List<RecoveryDTO> recoveryDTOS = new ArrayList<>();
        recoveries.forEach(recovery -> {
            StudentDTO studentDTO = studentService.getObjectFromRemoteService(recovery.getIdStudent());
            SanatoriumDTO sanatoriumDTO = SanatoriumMapper.toDTO(sanatoriumRepository.getSanatoriumById(recovery.getIdSanatorium()));
            RecoveryDTO recoveryDTO = RecoveryMapper.toDTO(recovery);
            recoveryDTO.setStudentDTO(studentDTO);
            recoveryDTO.setSanatoriumDTO(sanatoriumDTO);
            recoveryDTOS.add(recoveryDTO);
        });
        return CompletableFuture.completedFuture(recoveryDTOS);
    }
}