package ru.ibs.recruiters_happiness.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.ibs.recruiters_happiness.entities.Project;
import ru.ibs.recruiters_happiness.entities.Technology;
import ru.ibs.recruiters_happiness.entities.dto.ProjectDTO;
import ru.ibs.recruiters_happiness.repositories.ProjectRepository;
import ru.ibs.recruiters_happiness.services.ProjectServiceImpl;

import javax.validation.Valid;
import java.util.LinkedList;

@EnableAutoConfiguration
@RestController
@RequestMapping(value = "/hrdream", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ProjectServiceImpl projectService;

    @Autowired
    ModelMapper modelMapper;


    @GetMapping(value = "read", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object showJson(@RequestParam(required = false) Long id) {
        if (id != null) {
            Project project = projectService.showProjectById(id);
            return entityToDtoConv(project);
        } else {
            LinkedList<Project> projectList = new LinkedList<>(projectService.showAllProject());
            LinkedList<ProjectDTO> projectDTOList = new LinkedList<>();
            projectList.forEach(project -> projectDTOList.add(entityToDtoConv(project)));
            return projectDTOList;
        }


    }

    @PostMapping(value = "create", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object addProject(@RequestBody(required = false) @Valid ProjectDTO body, BindingResult bindingResult) {
            Project newProject = DtoToEntityConv(body);

            LinkedList<Technology> technologyLinkedList = new LinkedList<>();
            technologyLinkedList.addAll(newProject.getTechnology());

        if(!bindingResult.hasErrors())
            return projectService.addProject(newProject.getProject_name(), newProject.getProj_stage(), newProject.isGost_doc(),
                    newProject.getEnd_terms(), newProject.getFunc_direction(), newProject.getSubject_area(), newProject.getDescription(),
                    newProject.getProblem_to_solve(), newProject.getProjectAuthor(), newProject.getProjectCardStats(), newProject.getStakeholder_number(),
                    technologyLinkedList, newProject.getTeamInfo(), newProject.getProjectType(), newProject.getWorkingConditions());
        else
            return "переданы не верные данные по объекту Project";
    }



    private ProjectDTO entityToDtoConv(Project project){
        return modelMapper.map(project, ProjectDTO.class);
    }

    private Project DtoToEntityConv(ProjectDTO projectDto){
        return modelMapper.map(projectDto, Project.class);
    }

}
