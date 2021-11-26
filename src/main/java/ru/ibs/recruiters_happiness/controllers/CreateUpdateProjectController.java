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
            return projectService.showAllProject();
        }
    }



    @PostMapping(value = "create", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object addProject(@RequestBody(required = false) @Valid ProjectDTO projectDTO) {

        return projectService.addProject(projectDTO);
    }


    @PostMapping(value = "update", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateProject(@RequestParam(required = true) Long id, @RequestBody(required = false) @Valid ProjectDTO projectDTO) {

        projectService.updateProject(id, projectDTO);
        projectTypeService.updateProjectType(id, projectDTO);
        teamService.updateTeamInfo(id, projectDTO);
        workingConditionsService.updateWorkingConditions(id, projectDTO);

    }

    @PostMapping(value = "delete")
    public void deleteProject(@RequestParam(required = true) Long id) {
        projectService.deleteProject(id);
    }

    @PostMapping(value = "movetoarchive")
    public void moveProjectToArchive(@RequestParam(required = true) Long id) {
        projectService.moveProjectToArchive(id);
    }

    @PostMapping(value = "movefromarchive")
    public void moveProjectFromArchive(@RequestParam(required = true) Long id) {
        projectService.moveProjectFromArchive(id);
    }


    private ProjectDTO entityToDtoConv(Project project) {
        return modelMapper.map(project, ProjectDTO.class);
    }

    private Project DtoToEntityConv(ProjectDTO projectDto) {
        return modelMapper.map(projectDto, Project.class);
    }

}
