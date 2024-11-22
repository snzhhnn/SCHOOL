package com.school.recovery_service.controller.Impl;

import com.school.recovery_service.contract.RecoveryDTO;
import com.school.recovery_service.controller.IRecoveryController;
import com.school.recovery_service.service.IRecoveryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@AllArgsConstructor
@RequestMapping("/api/recovery")
public class RecoveryController implements IRecoveryController {

    private IRecoveryService service;

    @Override
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public CompletableFuture<RecoveryDTO> getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @Override
    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public CompletableFuture<RecoveryDTO> save(@RequestBody RecoveryDTO recoveryDTO) {
        return service.save(recoveryDTO);
    }

    @Override
    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.OK)
    public CompletableFuture<RecoveryDTO> update(@RequestBody RecoveryDTO recoveryDTO) {
        return service.update(recoveryDTO);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable UUID id) {
        service.deleteById(id);
    }

    @Override
    @GetMapping("/findAll")
    @ResponseStatus(code = HttpStatus.OK)
    public CompletableFuture<List<RecoveryDTO>> findAll() {
        return service.findAll();
    }

    @Override
    @GetMapping("/list")
    @ResponseStatus(code = HttpStatus.OK)
    public CompletableFuture<List<RecoveryDTO>> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }
}