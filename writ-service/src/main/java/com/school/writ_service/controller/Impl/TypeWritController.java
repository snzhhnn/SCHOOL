package com.school.writ_service.controller.Impl;

import com.school.writ_service.contract.TypeWritDTO;
import com.school.writ_service.controller.ITypeWritController;
import com.school.writ_service.service.ITypeWritService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@AllArgsConstructor
@RequestMapping("/api/typeWrit")
public class TypeWritController implements ITypeWritController {

    private ITypeWritService service;

    @Override
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public CompletableFuture<TypeWritDTO> getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @Override
    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public CompletableFuture<TypeWritDTO> save(@RequestBody TypeWritDTO typeWritDTO) {
        return service.save(typeWritDTO);
    }

    @Override
    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.OK)
    public CompletableFuture<TypeWritDTO> update(@RequestBody TypeWritDTO typeWritDTO) {
        return service.update(typeWritDTO);
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
    public CompletableFuture<List<TypeWritDTO>> findAll() {
        return service.findAll();
    }

    @Override
    @GetMapping("/list")
    @ResponseStatus(code = HttpStatus.OK)
    public CompletableFuture<List<TypeWritDTO>> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }
}