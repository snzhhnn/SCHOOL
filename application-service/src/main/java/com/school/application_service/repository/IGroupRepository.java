package com.school.application_service.repository;

import com.school.application_service.model.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface IGroupRepository extends CrudRepository<Group, UUID>, PagingAndSortingRepository<Group, UUID> {
    Group getGroupById(UUID id);
}