package com.school.recovery_service.repository;

import com.school.recovery_service.model.Sanatorium;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface ISanatoriumRepository extends CrudRepository<Sanatorium, UUID>, PagingAndSortingRepository<Sanatorium, UUID> {
    Sanatorium getSanatoriumById(UUID id);
}