package ru.ibs.recruiters_happiness.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.ibs.recruiters_happiness.entities.Project;
import ru.ibs.recruiters_happiness.entities.dto.ProjectDTO;
import ru.ibs.recruiters_happiness.repositories.ProjectRepository;
import ru.ibs.recruiters_happiness.repositories.ProjectTypeRepository;
import ru.ibs.recruiters_happiness.services.*;

import javax.validation.Valid;
import java.util.ArrayList;

@EnableAutoConfiguration
@RestController
@RequestMapping(value = "/hrdream", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
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
    TechnologyDictServiceImpl technologyService;

    @Autowired
    ModelMapper modelMapper;

    //Получить проект по id
    @GetMapping(value = "projects/{id}", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object showProject(@PathVariable(name = "id", required = true) Long id) {

        return projectService.showProjectById(id);

    }

    //Получить все проекты
    @GetMapping(value = "projects", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object showProjects() {

        return projectService.showAllProject();
    }

    //Создать проект
//    @PreAuthorize("hasRole('PM')")
    @PostMapping(value = "projects", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object addProject(@RequestBody(required = false) @Valid ProjectDTO projectDTO) {

        technologyService.parseToDict(projectDTO.getTechnology());
        return projectService.addProject(projectDTO);
    }

    //Обновить проект
    @PreAuthorize("hasRole('PM')")
    @PutMapping(value = "projects/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateProject(@PathVariable(name = "id", required = true) Long id, @RequestBody(required = false) @Valid ProjectDTO projectDTO) {

        projectService.updateProject(id, projectDTO);
        projectTypeService.updateProjectType(id, projectDTO);
        teamService.updateTeamInfo(id, projectDTO);
        workingConditionsService.updateWorkingConditions(id, projectDTO);

    }

    //Удалить проект
    @PreAuthorize("hasRole('PM')")
    @DeleteMapping(value = "projects/{id}")
    public void deleteProject(@PathVariable(name = "id", required = true) Long id) {
        projectService.deleteProject(id);
    }

    //Отправить в архив
    @PreAuthorize("hasAnyRole('PM', 'HR')")
    @PostMapping(value = "projects/archive/{id}")
    public void moveProjectToArchive(@PathVariable(name = "id", required = true) Long id) {
        projectService.moveProjectToArchive(id);
    }

    //Перенести из архива в активные
    @PreAuthorize("hasRole('PM')")
    @PostMapping(value = "projects/unzip/{id}")
    public void moveProjectFromArchive(@PathVariable(name = "id", required = true) Long id) {
        projectService.moveProjectFromArchive(id);
    }

    //Получить справочник технологий
    @PreAuthorize("hasRole('PM')")
    @GetMapping(value = "projects/tech", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object showTech() {
        return technologyService.dictLinkedList();
    }

//    private ProjectDTO entityToDtoConv(Project project) {
//        return modelMapper.map(project, ProjectDTO.class);
//    }
//
//    private Project DtoToEntityConv(ProjectDTO projectDto) {
//        return modelMapper.map(projectDto, Project.class);
//    }

}
