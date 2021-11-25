package ru.ibs.recruiters_happiness.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.ibs.recruiters_happiness.configuration.MapperUtil;
import ru.ibs.recruiters_happiness.entities.Project;
import ru.ibs.recruiters_happiness.entities.dto.ProjectInfoPageDTO;
import ru.ibs.recruiters_happiness.repositories.ProjectRepository;
import ru.ibs.recruiters_happiness.repositories.ProjectTypeRepository;
import ru.ibs.recruiters_happiness.services.ProjectServiceImpl;
import ru.ibs.recruiters_happiness.services.ProjectTypeServiceImpl;
import ru.ibs.recruiters_happiness.services.TeamServiceImpl;
import ru.ibs.recruiters_happiness.services.WorkingConditionsServiceImpl;

import java.util.List;

@EnableAutoConfiguration
@RestController
@RequestMapping(value = "/hrdream/projectsinfo", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
public class AllProjectsInfoController {

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

    //выводим все проекты со всеми полями
    @GetMapping(value = "allprojects",  produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProjectInfoPageDTO> showProjectDTO(){
//        List<Project> projects = projectService.showAllProjectInfo();
        return projectService.showAllProjectInfo();
    }

    @GetMapping(value = "allprojects/sortby/{sortType}",  produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProjectInfoPageDTO> showProjectDTOSortBy(@PathVariable(name = "sortType", required = true) String sortType){
        return projectService.showAllProjectInfoSortBy(sortType);
    }

    @GetMapping(value = "allprojects/filterby/customer",  produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProjectInfoPageDTO> showProjectDTOFilterByCustomer(@RequestParam(required = true) String customer){
        return projectService.showAllProjectInfoFilteredByCustomer(customer);
    }


    //метод для мапинга всех карточек проекта в ДТО который передает только основные поля
    private ProjectInfoPageDTO entityToAllProjDtoConv(Project project) {
        return modelMapper.map(project, ProjectInfoPageDTO.class);
    }

}
