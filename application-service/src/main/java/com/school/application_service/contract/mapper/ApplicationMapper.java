package com.school.application_service.contract.mapper;

import com.school.application_service.contract.ApplicationDTO;
import com.school.application_service.model.Application;
import com.school.application_service.model.Group;

public class ApplicationMapper {
    public static Application toEntity(ApplicationDTO applicationDTO) {
        return Application.builder()
                .id(applicationDTO.getId())
                .date(applicationDTO.getDate())
                .countExtendedDay(applicationDTO.getCountExtendedDay())
                .countDiet(applicationDTO.getCountDiet())
                .totalCount(applicationDTO.getTotalCount())
                .group(Group.builder().id(applicationDTO.getGroupUUID()).build())
                .build();
    }

    public static ApplicationDTO toDTO(Application application) {
        return ApplicationDTO.builder()
                .id(application.getId())
                .date(application.getDate())
                .countExtendedDay(application.getCountExtendedDay())
                .countDiet(application.getCountDiet())
                .totalCount(application.getTotalCount())
                .groupUUID(application.getGroup().getId())
                .build();
    }
}