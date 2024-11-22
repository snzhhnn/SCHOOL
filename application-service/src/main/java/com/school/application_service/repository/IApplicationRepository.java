package com.school.application_service.repository;

import com.school.application_service.model.Application;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface IApplicationRepository extends CrudRepository<Application, UUID>, PagingAndSortingRepository<Application, UUID> {
    Application getApplicationById(UUID id);
}