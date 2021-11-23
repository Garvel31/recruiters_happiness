package ru.ibs.recruiters_happiness.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.recruiters_happiness.entities.ProjectType;
import ru.ibs.recruiters_happiness.repositories.ProjectTypeRepository;
import ru.ibs.recruiters_happiness.services.interfaces.ProjectTypeService;

@Service
public class ProjectTypeServiceImpl implements ProjectTypeService {

    @Autowired
    ProjectTypeRepository projectTypeRepository;

    @Override
    public ProjectType addProjectType(boolean isPayType, boolean isPO, boolean isMVP, boolean isFromScratch) {
        final ProjectType projectType = new ProjectType(isPayType,  isPO,  isMVP,  isFromScratch);

        return projectTypeRepository.save(projectType);
    }
}
