package com.school.recovery_service.controller.Impl;

import com.school.recovery_service.contract.SanatoriumDTO;
import com.school.recovery_service.controller.ISanatoriumController;
import com.school.recovery_service.service.ISanatoriumService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@AllArgsConstructor
@RequestMapping("/api/sanatorium")
public class SanatoriumController implements ISanatoriumController {

    private ISanatoriumService service;

    @Override
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public CompletableFuture<SanatoriumDTO> getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @Override
    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public CompletableFuture<SanatoriumDTO> save(@RequestBody SanatoriumDTO sanatoriumDTO) {
        return service.save(sanatoriumDTO);
    }

    @Override
    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.OK)
    public CompletableFuture<SanatoriumDTO> update(@RequestBody SanatoriumDTO sanatoriumDTO) {
        return service.update(sanatoriumDTO);
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
    public CompletableFuture<List<SanatoriumDTO>> findAll() {
        return service.findAll();
    }


    @Override
    @GetMapping("/list")
    @ResponseStatus(code = HttpStatus.OK)
    public CompletableFuture<List<SanatoriumDTO>> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }
}