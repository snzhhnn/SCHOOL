package com.school.writ_service.controller.Impl;

import com.school.writ_service.contract.WritDTO;
import com.school.writ_service.controller.IWritController;
import com.school.writ_service.service.IWritService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@AllArgsConstructor
@RequestMapping("/api/writ")
public class WritController implements IWritController {

    private IWritService service;

    @Override
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public CompletableFuture<WritDTO> getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @Override
    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public CompletableFuture<WritDTO> save(@RequestBody WritDTO writDTO) {
        return service.save(writDTO);
    }

    @Override
    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.OK)
    public CompletableFuture<WritDTO> update(@RequestBody WritDTO writDTO) {
        return service.save(writDTO);
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
    public CompletableFuture<List<WritDTO>> findAll() {
        return service.findAll();
    }

    @Override
    @GetMapping("/list")
    @ResponseStatus(code = HttpStatus.OK)
    public CompletableFuture<List<WritDTO>> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }
}