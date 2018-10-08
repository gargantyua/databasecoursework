package com.kuptsov.databasecoursework.mapper;

import com.kuptsov.databasecoursework.dto.create.CreateEmployerDTO;
import com.kuptsov.databasecoursework.dto.delete.DeleteEmployerDTO;
import com.kuptsov.databasecoursework.dto.update.UpdateEmployerDTO;
import com.kuptsov.databasecoursework.model.Employer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface EmployerMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "title", source = "createEmployerDTO.title"),
            @Mapping(target = "activity", source = "createEmployerDTO.activity"),
            @Mapping(target = "address", source = "createEmployerDTO.address"),
            @Mapping(target = "telephone", source = "createEmployerDTO.telephone"),
            @Mapping(target = "deleted", ignore = true),
    })
    Employer toEntity(CreateEmployerDTO createEmployerDTO);

    @Mappings({
            @Mapping(target = "id", source = "deleteEmployerDTO.id"),
            @Mapping(target = "title", ignore = true),
            @Mapping(target = "activity", ignore = true),
            @Mapping(target = "address", ignore = true),
            @Mapping(target = "telephone", ignore = true),
            @Mapping(target = "deleted", ignore = true),
    })
    Employer toEntity(DeleteEmployerDTO deleteEmployerDTO);

    @Mappings({
            @Mapping(target = "id", source = "updateEmployerDTO.id"),
            @Mapping(target = "title", source = "updateEmployerDTO.title"),
            @Mapping(target = "activity", source = "updateEmployerDTO.activity"),
            @Mapping(target = "address", source = "updateEmployerDTO.address"),
            @Mapping(target = "telephone", source = "updateEmployerDTO.telephone"),
            @Mapping(target = "deleted", ignore = true),
    })
    Employer toEntity(UpdateEmployerDTO updateEmployerDTO);
}
