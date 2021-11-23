package ru.ibs.recruiters_happiness.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.recruiters_happiness.entities.*;
import ru.ibs.recruiters_happiness.repositories.ProjectRepository;
import ru.ibs.recruiters_happiness.services.interfaces.ProjectService;

import java.util.LinkedList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    TechnologyServiceImpl technologyService;

    @Override
    public Project addProject(String project_name, String proj_stage, boolean gost_doc, String end_terms, String func_direction, String subject_area,
                              String description, String problem_to_solve, String projectAuthor, String projectCardStats, int stakeholder_number,
                              LinkedList<Technology> technologyList, TeamInfo teamInfo, ProjectType projectType, WorkingConditions workingConditions) {
        final Project newProject = new Project(project_name, proj_stage, gost_doc, end_terms, func_direction, subject_area,
                description, problem_to_solve, projectAuthor, projectCardStats, stakeholder_number);


        newProject.setProjectType(projectType);
        newProject.setTeamInfo(teamInfo);
        newProject.setWorkingConditions(workingConditions);
        technologyList.forEach(technology -> {
            technology.setProject(newProject);
            newProject.getTechnology().add(technology);
        });

        return projectRepository.save(newProject);
    }

    public Project showProjectById(Long id) {
        return projectRepository.findProjectById(id);
    }

    public LinkedList<Project> showAllProject() {
        return new LinkedList<>(projectRepository.findAll());
    }
}
