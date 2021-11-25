package ru.ibs.recruiters_happiness.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

//    @Autowired
//    TechnologyServiceImpl technologyService;

    @Override
    public Project addProject(String project_name, String customer, String proj_stage, boolean gost_doc, String end_terms, String func_direction, String subject_area,
                              String description, String problem_to_solve, String projectAuthor, int stakeholder_number, String technology,
                              TeamInfo teamInfo, ProjectType projectType, WorkingConditions workingConditions) {

        final Project newProject = new Project(project_name, customer, proj_stage, gost_doc, end_terms, func_direction, subject_area,
                description, problem_to_solve, projectAuthor, stakeholder_number, technology);

        newProject.setProjectType(projectType);
        projectType.setProject(newProject);
        newProject.setTeamInfo(teamInfo);
        teamInfo.setProject(newProject);
        newProject.setWorkingConditions(workingConditions);
        workingConditions.setProject(newProject);
//        technologyList.forEach(technology -> {
//            technology.setProject(newProject);
//            newProject.getTechnology().add(technology);
//        });
        return projectRepository.save(newProject);
    }

    public Project updateProject(Long id, String project_name, String customer, String proj_stage, boolean gost_doc, String end_terms, String func_direction, String subject_area,
                              String description, String problem_to_solve, String projectAuthor, int stakeholder_number, String technology){

        Project newProject = projectRepository.findProjectById(id);
        newProject.setProject_name(project_name);
        newProject.setCustomer(customer);
        newProject.setProj_stage(proj_stage);
        newProject.setGost_doc(gost_doc);
        newProject.setEnd_terms(end_terms);
        newProject.setFunc_direction(func_direction);
        newProject.setSubject_area(subject_area);
        newProject.setDescription(description);
        newProject.setProblem_to_solve(problem_to_solve);
        newProject.setProjectAuthor(projectAuthor);
        newProject.setStakeholder_number(stakeholder_number);
        newProject.setTechnology(technology);

        return projectRepository.save(newProject);
    }


    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    public Project showProjectById(Long id) {
        return projectRepository.findProjectById(id);
    }

    public List<Project> showAllProject() {
        return new LinkedList<>(projectRepository.findAll());
    }

    public List<Project> showAllProjectInfoSortByCustomer() {
        return projectRepository.findAll(Sort.by(Sort.Direction.ASC, "customer"));
    }
}
