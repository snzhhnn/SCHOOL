package com.school.application_service.controller.Impl;

import com.school.application_service.contract.GroupDTO;
import com.school.application_service.controller.IGroupController;
import com.school.application_service.service.IGroupService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/group")
@AllArgsConstructor
@CrossOrigin
public class GroupController implements IGroupController {

    private IGroupService service;

    @Override
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public CompletableFuture<GroupDTO> getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @Override
    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public CompletableFuture<GroupDTO> save(@RequestBody GroupDTO groupDTO) {
        return service.save(groupDTO);
    }

    @Override
    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.OK)
    public CompletableFuture<GroupDTO> update(@RequestBody GroupDTO groupDTO) {
        return service.update(groupDTO);
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
    public CompletableFuture<List<GroupDTO>> findAll() {
        return service.findAll();
    }

    @Override
    @GetMapping("/list")
    @ResponseStatus(code = HttpStatus.OK)
    public CompletableFuture<List<GroupDTO>> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }
}