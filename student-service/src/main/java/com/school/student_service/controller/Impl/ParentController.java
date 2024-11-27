package com.school.student_service.controller.Impl;

import com.school.student_service.contract.ParentDTO;
import com.school.student_service.controller.IParentController;
import com.school.student_service.service.IParentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/parent")
@AllArgsConstructor
@CrossOrigin
public class ParentController implements IParentController {

    private IParentService service;

    @Override
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public CompletableFuture<ParentDTO> getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @Override
    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public CompletableFuture<ParentDTO> save(@RequestBody ParentDTO parentDTO) {
        return service.save(parentDTO);
    }

    @Override
    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.OK)
    public CompletableFuture<ParentDTO> update(@RequestBody ParentDTO parentDTO) {
        return service.update(parentDTO);
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
    public CompletableFuture<List<ParentDTO>> findAll() {
        return service.findAll();
    }

    @Override
    @GetMapping("/list")
    @ResponseStatus(code = HttpStatus.OK)
    public CompletableFuture<List<ParentDTO>> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }
}