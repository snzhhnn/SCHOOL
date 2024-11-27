package com.school.writ_service.contract.mapper;

import com.school.writ_service.contract.StudentDTO;
import com.school.writ_service.contract.WritDTO;
import com.school.writ_service.model.TypeWrit;
import com.school.writ_service.model.Writ;
import com.school.writ_service.service.Impl.StudentService;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class WritMapper {
    public static Writ toEntity(WritDTO writDTO) {
        List<UUID> uuids= writDTO.getStudentUUID();
        StudentService studentService = new StudentService(new RestTemplate());
        ArrayList<StudentDTO> studentDTOS = new ArrayList<>();
        for (UUID id: uuids) {
            studentDTOS.add(studentService.getObjectFromRemoteService(id));
        }
        return Writ.builder()
                .id(writDTO.getId())
                .date(writDTO.getDate())
                .typeWrit(TypeWrit.builder().id(writDTO.getIdTypeWrit()).build())
                .studentDTOS(studentDTOS)
                .build();
    }

    public static WritDTO toDTO(Writ writ) {
        List<UUID> uuids = writ.getStudentDTOS().stream()
                .map(StudentDTO::getId)
                .toList();
        return WritDTO.builder()
                .id(writ.getId())
                .date(writ.getDate())
                .idTypeWrit(writ.getTypeWrit().getId())
                .studentUUID(uuids)
                .build();
    }
}