package com.school.student_service.controller.Impl;

import com.school.student_service.contract.StudentDTO;
import com.school.student_service.controller.IStudentController;
import com.school.student_service.service.IStudentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/student")
@AllArgsConstructor
@CrossOrigin
public class StudentController implements IStudentController {

    private IStudentService service;

    @Override
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public CompletableFuture<StudentDTO> getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @Override
    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public CompletableFuture<StudentDTO> save(@RequestBody StudentDTO studentDTO) {
        return service.save(studentDTO);
    }

    @Override
    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.OK)
    public CompletableFuture<StudentDTO> update(@RequestBody StudentDTO studentDTO) {
        return service.update(studentDTO);
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
    public CompletableFuture<List<StudentDTO>> findAll() {
        return service.findAll();
    }

    @Override
    @GetMapping("/list")
    @ResponseStatus(code = HttpStatus.OK)
    public CompletableFuture<List<StudentDTO>> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }
}