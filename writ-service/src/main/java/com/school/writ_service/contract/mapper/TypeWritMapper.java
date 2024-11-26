package com.school.writ_service.contract.mapper;

import com.school.writ_service.contract.TypeWritDTO;
import com.school.writ_service.model.TypeWrit;
import com.school.writ_service.model.Writ;

import java.util.List;
import java.util.UUID;

public class TypeWritMapper {
    public static TypeWrit toEntity(TypeWritDTO typeWritDTO) {
        return TypeWrit.builder()
                .id(typeWritDTO.getId())
                .title(typeWritDTO.getTitle())
                .description(typeWritDTO.getDescription())
                .build();
    }

    public static TypeWritDTO toDTO(TypeWrit typeWrit) {
        return TypeWritDTO.builder()
                .id(typeWrit.getId())
                .title(typeWrit.getTitle())
                .description(typeWrit.getDescription())
                .build();
    }
}
