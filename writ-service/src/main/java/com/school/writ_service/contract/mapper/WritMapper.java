package com.school.writ_service.contract.mapper;

import com.school.writ_service.contract.WritDTO;
import com.school.writ_service.model.TypeWrit;
import com.school.writ_service.model.Writ;

public class WritMapper {
    public static Writ toEntity(WritDTO writDTO) {
        return Writ.builder()
                .id(writDTO.getId())
                .date(writDTO.getDate())
                .typeWrit(TypeWrit.builder().id(writDTO.getIdTypeWrit()).build())
                .build();
    }

    public static WritDTO toDTO(Writ writ) {
        return WritDTO.builder()
                .id(writ.getId())
                .date(writ.getDate())
                .idTypeWrit(writ.getTypeWrit().getId())
                .build();
    }
}