package com.school.application_service.contract.mapper;

import com.school.application_service.contract.GroupDTO;
import com.school.application_service.model.Group;

public class GroupMapper {
    public static Group toEntity(GroupDTO groupDTO) {
        return Group.builder()
                .id(groupDTO.getId())
                .number(groupDTO.getNumber())
                .letter(groupDTO.getLetter())
                .build();
    }

    public static GroupDTO toDTO(Group group) {
        return GroupDTO.builder()
                .id(group.getId())
                .number(group.getNumber())
                .letter(group.getLetter())
                .build();
    }
}