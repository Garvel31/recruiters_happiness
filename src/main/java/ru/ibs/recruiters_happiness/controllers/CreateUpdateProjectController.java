package ru.ibs.recruiters_happiness.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.ibs.recruiters_happiness.configuration.MapperUtil;
import ru.ibs.recruiters_happiness.entities.Project;
import ru.ibs.recruiters_happiness.entities.dto.ProjectDTO;
import ru.ibs.recruiters_happiness.entities.dto.ProjectInfoPageDTO;
import ru.ibs.recruiters_happiness.repositories.ProjectRepository;
import ru.ibs.recruiters_happiness.repositories.ProjectTypeRepository;
import ru.ibs.recruiters_happiness.services.ProjectServiceImpl;
import ru.ibs.recruiters_happiness.services.ProjectTypeServiceImpl;

import ru.ibs.recruiters_happiness.services.TeamServiceImpl;
import ru.ibs.recruiters_happiness.services.WorkingConditionsServiceImpl;
import ru.ibs.recruiters_happiness.services.interfaces.ProjectTypeService;

import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;

@EnableAutoConfiguration
@RestController
@RequestMapping(value = "/hrdream/projectcard", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
public class CreateUpdateProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ProjectTypeRepository projectTypeRepository;

    @Autowired
    ProjectServiceImpl projectService;

//    @Autowired
//    TechnologyServiceImpl technologyService;

    @Autowired
    ProjectTypeServiceImpl projectTypeService;

    @Autowired
    TeamServiceImpl teamService;

    @Autowired
    WorkingConditionsServiceImpl workingConditionsService;

    @Autowired
    ModelMapper modelMapper;


    @GetMapping(value = "read", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object showProjects(@RequestParam(required = false) Long id) {
        if (id != null) {
            return projectService.showProjectById(id);
        } else {
//            LinkedList<Project> projectList = new LinkedList<>();
//            LinkedList<ProjectDTO> projectDTOList = new LinkedList<>();
//            projectList.forEach(project -> projectDTOList.add(entityToDtoConv(project)));
            return projectService.showAllProject();
        }

    }

    @PostMapping(value = "create", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object addProject(@RequestBody(required = false) @Valid ProjectDTO projectDTO) {
//        Project newProject = DtoToEntityConv(body);
//        LinkedList<Technology> technologyLinkedList = new LinkedList<>();
//        technologyLinkedList.addAll(newProject.getTechnology());
//
        return projectService.addProject(projectDTO);
    }

    @PostMapping(value = "update", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateProject(@RequestParam(required = true) Long id, @RequestBody(required = false) @Valid ProjectDTO projectDTO) {
        Project newProject = MapperUtil.DtoToEntityConv(projectDTO, modelMapper);
//        LinkedList<Technology> technologyLinkedList = new LinkedList<>();
//        technologyLinkedList.addAll(newProject.getTechnology());
//        projectService.updateProject(id, newProject.getProject_name(), newProject.getCustomer(), newProject.getProj_stage(), newProject.isGost_doc(),
//                newProject.getEnd_terms(), newProject.getFunc_direction(), newProject.getSubject_area(), newProject.getDescription(),
//                newProject.getProblem_to_solve(), newProject.getProjectAuthor(), newProject.getStakeholder_number(),
//                newProject.getTechnology());
        projectService.updateProject(id, projectDTO);
        projectTypeService.updateProjectType(id, projectDTO);
        teamService.updateTeamInfo(id, projectDTO);
        workingConditionsService.updateWorkingConditions(id,projectDTO);

    }

    @PostMapping(value = "delete")
    public void deleteProject(@RequestParam(required = true) Long id) {
        projectService.deleteProject(id);
    }



    private ProjectDTO entityToDtoConv(Project project) {
        return modelMapper.map(project, ProjectDTO.class);
    }

    private Project DtoToEntityConv(ProjectDTO projectDto) {
        return modelMapper.map(projectDto, Project.class);
    }

}
