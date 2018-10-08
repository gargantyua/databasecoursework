package com.kuptsov.databasecoursework.mapper;

import com.kuptsov.databasecoursework.dto.create.CreateVacancyDTO;
import com.kuptsov.databasecoursework.dto.delete.DeleteVacancyDTO;
import com.kuptsov.databasecoursework.dto.update.UpdateVacancyDTO;
import com.kuptsov.databasecoursework.model.Vacancy;
import com.kuptsov.databasecoursework.repository.EmployerRepository;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class VacancyMapper {

    @Autowired
    private EmployerRepository employerRepository;

    public Vacancy toEntity(CreateVacancyDTO createVacancyDTO) {
        Vacancy vacancy = new Vacancy();
        vacancy.setEmployer(employerRepository.findByTitle(createVacancyDTO.getEmployerTitle()).orElse(null));
        vacancy.setQualification(createVacancyDTO.getQualification());
        vacancy.setPosition(createVacancyDTO.getPosition());
        vacancy.setOfferedSalary(createVacancyDTO.getOfferedSalary());

        return vacancy;
    }

    public Vacancy toEntity(DeleteVacancyDTO deleteVacancyDTO) {
        Vacancy vacancy = new Vacancy();
        vacancy.setId(deleteVacancyDTO.getId());

        return vacancy;
    }

    public Vacancy toEntity(UpdateVacancyDTO updateVacancyDTO) {
        Vacancy vacancy = new Vacancy();
        vacancy.setId(updateVacancyDTO.getId());
        vacancy.setQualification(updateVacancyDTO.getQualification());
        vacancy.setPosition(updateVacancyDTO.getPosition());
        vacancy.setOfferedSalary(updateVacancyDTO.getOfferedSalary());

        return vacancy;
    }
}
