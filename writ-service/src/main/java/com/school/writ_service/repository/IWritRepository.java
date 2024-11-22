package com.school.writ_service.repository;

import com.school.writ_service.model.Writ;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface IWritRepository extends CrudRepository<Writ, UUID>, PagingAndSortingRepository<Writ, UUID> {
    Writ getWritById(UUID id);
}