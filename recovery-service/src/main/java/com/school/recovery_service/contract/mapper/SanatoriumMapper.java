package com.school.recovery_service.contract.mapper;

import com.school.recovery_service.contract.SanatoriumDTO;
import com.school.recovery_service.model.Sanatorium;

public class SanatoriumMapper {
    public static Sanatorium toEntity(SanatoriumDTO sanatoriumDTO) {
        return Sanatorium.builder()
                .id(sanatoriumDTO.getId())
                .title(sanatoriumDTO.getTitle())
                .city(sanatoriumDTO.getCity())
                .build();
    }

    public static SanatoriumDTO toDTO(Sanatorium sanatorium) {
        return SanatoriumDTO.builder()
                .id(sanatorium.getId())
                .title(sanatorium.getTitle())
                .city(sanatorium.getCity())
                .build();
    }
}