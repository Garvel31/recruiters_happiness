package ru.ibs.recruiters_happiness.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.recruiters_happiness.configuration.MapperUtil;
import ru.ibs.recruiters_happiness.entities.Project;
import ru.ibs.recruiters_happiness.entities.ProjectType;
import ru.ibs.recruiters_happiness.entities.dto.ProjectDTO;
import ru.ibs.recruiters_happiness.repositories.ProjectRepository;
import ru.ibs.recruiters_happiness.repositories.ProjectTypeRepository;
import ru.ibs.recruiters_happiness.services.interfaces.ProjectTypeService;

@Service
public class ProjectTypeServiceImpl implements ProjectTypeService {

    @Autowired
    ProjectTypeRepository projectTypeRepository;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ProjectType addProjectType(boolean isPayType, boolean isPO, boolean isMVP, boolean isFromScratch) {
        final ProjectType projectType = new ProjectType(isPayType, isPO, isMVP, isFromScratch);

        return projectTypeRepository.save(projectType);
    }


public ProjectType updateProjectType(Long projectid, ProjectDTO projectDTO) {
            Project project = MapperUtil.DtoToEntityConv(projectDTO, modelMapper);
    //        ProjectType projectType = projectTypeRepository.findProjectTypeByProjectId(projectid);
            ProjectType projectType = projectTypeRepository.findProjectTypeById(projectRepository.findProjectById(projectid).getProjectType().getId());
            projectType.setPayType(project.getProjectType().isPayType());
            projectType.setPO(project.getProjectType().isPO());
            projectType.setMVP(project.getProjectType().isMVP());
            projectType.setFromScratch(project.getProjectType().isFromScratch());
            return projectTypeRepository.save(projectType);
    }


}
