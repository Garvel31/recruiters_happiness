package ru.ibs.recruiters_happiness.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.recruiters_happiness.configuration.MapperUtil;
import ru.ibs.recruiters_happiness.entities.Project;
import ru.ibs.recruiters_happiness.entities.TeamInfo;
import ru.ibs.recruiters_happiness.entities.WorkingConditions;
import ru.ibs.recruiters_happiness.entities.dto.ProjectDTO;
import ru.ibs.recruiters_happiness.repositories.WorkingConditionsRepository;
import ru.ibs.recruiters_happiness.services.interfaces.WorkingConditionsService;

@Service
public class WorkingConditionsServiceImpl implements WorkingConditionsService {

    @Autowired
    WorkingConditionsRepository workingConditionsRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public WorkingConditions addWorkingConditions(boolean isInOffice, boolean isTimeLag, boolean isOverTimeExpect, int lagOfTime, String procedure, String adress) {
        final WorkingConditions workingConditions = new WorkingConditions(isInOffice, isTimeLag, isOverTimeExpect, lagOfTime, procedure, adress);
        return workingConditionsRepository.save(workingConditions);
    }

    public void updateWorkingConditions(Long projectid, ProjectDTO projectDTO) {
        Project project = MapperUtil.DtoToEntityConv(projectDTO, modelMapper);
        WorkingConditions workingConditions = workingConditionsRepository.findByProjectId(projectid);
        workingConditions.setInOffice(project.getWorkingConditions().isInOffice());
        workingConditions.setTimeLag(project.getWorkingConditions().isTimeLag());
        workingConditions.setOverTimeExpect(project.getWorkingConditions().isOverTimeExpect());
        workingConditions.setLagOfTime(project.getWorkingConditions().getLagOfTime());
        workingConditions.setProcedure(project.getWorkingConditions().getProcedure());
        workingConditionsRepository.save(workingConditions);
    }
}
