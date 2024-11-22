package com.school.application_service.controller.Impl;

import com.school.application_service.contract.ApplicationDTO;
import com.school.application_service.controller.IApplicationController;
import com.school.application_service.service.IApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;


@RestController
@RequestMapping("api/application")
@AllArgsConstructor
@CrossOrigin
public class ApplicationController implements IApplicationController {

    private IApplicationService service;

    @Override
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public CompletableFuture<ApplicationDTO> getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @Override
    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public CompletableFuture<ApplicationDTO> save(@RequestBody ApplicationDTO applicationDTO) {
        return service.save(applicationDTO);
    }

    @Override
    @PostMapping("/update")
    @ResponseStatus(code = HttpStatus.OK)
    public CompletableFuture<ApplicationDTO> update(@RequestBody ApplicationDTO applicationDTO) {
        return service.update(applicationDTO);
    }

    @Override
    @PostMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable UUID id) {
        service.deleteById(id);
    }

    @Override
    @GetMapping("/findAll")
    @ResponseStatus(code = HttpStatus.OK)
    public CompletableFuture<List<ApplicationDTO>> findAll() {
        return service.findAll();
    }

    @Override
    @PostMapping("/list")
    @ResponseStatus(code = HttpStatus.OK)
    public CompletableFuture<List<ApplicationDTO>> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }
}