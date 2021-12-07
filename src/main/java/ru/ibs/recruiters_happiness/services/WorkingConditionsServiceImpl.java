package ru.ibs.recruiters_happiness.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.recruiters_happiness.configuration.MapperUtil;
import ru.ibs.recruiters_happiness.entities.Project;
import ru.ibs.recruiters_happiness.entities.TeamInfo;
import ru.ibs.recruiters_happiness.entities.WorkingConditions;
import ru.ibs.recruiters_happiness.entities.dto.ProjectDTO;
import ru.ibs.recruiters_happiness.repositories.ProjectRepository;
import ru.ibs.recruiters_happiness.repositories.WorkingConditionsRepository;
import ru.ibs.recruiters_happiness.services.interfaces.WorkingConditionsService;

@Service
public class WorkingConditionsServiceImpl implements WorkingConditionsService {

    @Autowired
    WorkingConditionsRepository workingConditionsRepository;

    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public WorkingConditions addWorkingConditions(boolean isInOffice, boolean isTimeLag, boolean isOverTimeExpect, String schedule, String procedure, String adress) {
        final WorkingConditions workingConditions = new WorkingConditions(isInOffice, isTimeLag, isOverTimeExpect, schedule, procedure, adress);
        return workingConditionsRepository.save(workingConditions);
    }

    public void updateWorkingConditions(Long projectid, ProjectDTO projectDTO) {
        Project project = MapperUtil.DtoToEntityConv(projectDTO, modelMapper);
//        WorkingConditions workingConditions = workingConditionsRepository.findByProjectId(projectid);
        WorkingConditions workingConditions = workingConditionsRepository.findWorkingConditionsById(projectRepository.findProjectById(projectid).getWorkingConditions().getId());
        workingConditions.setAdress(project.getWorkingConditions().getAdress());
        workingConditions.setInOffice(project.getWorkingConditions().isInOffice());
        workingConditions.setTimeLag(project.getWorkingConditions().isTimeLag());
        workingConditions.setOverTimeExpect(project.getWorkingConditions().isOverTimeExpect());
        workingConditions.setSchedule(project.getWorkingConditions().getSchedule());
        workingConditions.setProcedure(project.getWorkingConditions().getProcedure());
        workingConditionsRepository.save(workingConditions);
    }
}
