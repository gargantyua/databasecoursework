package com.kuptsov.databasecoursework.mapper;

import com.kuptsov.databasecoursework.dto.create.CreateApplicantDTO;
import com.kuptsov.databasecoursework.dto.delete.DeleteApplicantDTO;
import com.kuptsov.databasecoursework.dto.update.UpdateApplicantDTO;
import com.kuptsov.databasecoursework.model.Applicant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ApplicantMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "surname", source = "createApplicantDTO.surname"),
            @Mapping(target = "name", source = "createApplicantDTO.name"),
            @Mapping(target = "patronymic", source = "createApplicantDTO.patronymic"),
            @Mapping(target = "qualification", source = "createApplicantDTO.qualification"),
            @Mapping(target = "activity", source = "createApplicantDTO.activity"),
            @Mapping(target = "otherInfo", source = "createApplicantDTO.otherInfo"),
            @Mapping(target = "wantedSalary", source = "createApplicantDTO.wantedSalary"),
            @Mapping(target = "deleted", ignore = true)
    })
    Applicant toEntity(CreateApplicantDTO createApplicantDTO);

    @Mappings({
            @Mapping(target = "id", source = "deleteApplicantDTO.id"),
            @Mapping(target = "surname", ignore = true),
            @Mapping(target = "name", ignore = true),
            @Mapping(target = "patronymic", ignore = true),
            @Mapping(target = "qualification", ignore = true),
            @Mapping(target = "activity", ignore = true),
            @Mapping(target = "otherInfo", ignore = true),
            @Mapping(target = "wantedSalary", ignore = true),
            @Mapping(target = "deleted", ignore = true)
    })
    Applicant toEntity(DeleteApplicantDTO deleteApplicantDTO);

    @Mappings({
            @Mapping(target = "id", source = "updateApplicantDTO.id"),
            @Mapping(target = "surname", source = "updateApplicantDTO.surname"),
            @Mapping(target = "name", source = "updateApplicantDTO.name"),
            @Mapping(target = "patronymic", source = "updateApplicantDTO.patronymic"),
            @Mapping(target = "qualification", source = "updateApplicantDTO.qualification"),
            @Mapping(target = "activity", source = "updateApplicantDTO.activity"),
            @Mapping(target = "otherInfo", source = "updateApplicantDTO.otherInfo"),
            @Mapping(target = "wantedSalary", source = "updateApplicantDTO.wantedSalary"),
            @Mapping(target = "deleted", ignore = true)
    })
    Applicant toEntity(UpdateApplicantDTO updateApplicantDTO);
}
