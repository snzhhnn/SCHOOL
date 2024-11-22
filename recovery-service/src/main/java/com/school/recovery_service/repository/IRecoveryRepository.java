package com.school.recovery_service.repository;

import com.school.recovery_service.model.Recovery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface IRecoveryRepository extends CrudRepository<Recovery, UUID>, PagingAndSortingRepository<Recovery, UUID> {
    Recovery getRecoveryById(UUID id);
}