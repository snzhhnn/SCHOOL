package com.school.writ_service.contract.mapper;

import com.school.writ_service.contract.TypeWritDTO;
import com.school.writ_service.model.TypeWrit;
import com.school.writ_service.model.Writ;

import java.util.List;
import java.util.UUID;

public class TypeWritMapper {
    public static TypeWrit toEntity(TypeWritDTO typeWritDTO) {
        List<Writ> writs = typeWritDTO.getWritsUUID()
                .stream()
                .map((id) -> Writ.builder().id(id).build())
                .toList();
        return TypeWrit.builder()
                .id(typeWritDTO.getId())
                .title(typeWritDTO.getTitle())
                .description(typeWritDTO.getDescription())
                .writs(writs)
                .build();
    }

    public static TypeWritDTO toDTO(TypeWrit typeWrit) {
        List<UUID> writsIds = typeWrit.getWrits()
                .stream()
                .map(Writ::getId)
                .toList();
        return TypeWritDTO.builder()
                .id(typeWrit.getId())
                .title(typeWrit.getTitle())
                .description(typeWrit.getDescription())
                .writsUUID(writsIds)
                .build();
    }
}
