package com.school.writ_service.repository;

import com.school.writ_service.model.TypeWrit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface ITypeWritRepository extends CrudRepository<TypeWrit, UUID>, PagingAndSortingRepository<TypeWrit, UUID> {
    TypeWrit getTypeWritById(UUID id);
}