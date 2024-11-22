package com.school.recovery_service.contract.mapper;

import com.school.recovery_service.contract.RecoveryDTO;
import com.school.recovery_service.model.Recovery;
import com.school.recovery_service.model.Sanatorium;

public class RecoveryMapper {

    public static Recovery toEntity(RecoveryDTO recoveryDTO) {
        return Recovery.builder()
                .id(recoveryDTO.getId())
                .startDate(recoveryDTO.getStartDate())
                .endDate(recoveryDTO.getEndDate())
                .idStudent(recoveryDTO.getIdStudent())
                .sanatorium(Sanatorium.builder().id(recoveryDTO.getIdSanatorium()).build())
                .build();
    }

    public static RecoveryDTO toDTO(Recovery recovery) {
        return RecoveryDTO.builder()
                .id(recovery.getId())
                .startDate(recovery.getStartDate())
                .endDate(recovery.getEndDate())
                .idStudent(recovery.getIdStudent())
                .idSanatorium(recovery.getSanatorium().getId())
                .build();
    }
}