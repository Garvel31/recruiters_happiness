package ru.ibs.recruiters_happiness.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
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
@RequestMapping(value = "/hrdream/projectlist", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
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

    //выводим все проекты с основными полями активные и не черновики
//    @PreAuthorize("hasAnyRole('PM', 'HR')")
    @GetMapping(value = "activeprojects",  produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProjectInfoPageDTO> showProjectDTO(){
        return projectService.showAllProjectInfo();
    }

    //сортировка по полю, поле передаем в path var
    @PreAuthorize("hasAnyRole('PM', 'HR')")
    @GetMapping(value = "activeprojects/sortby/{sortType}",  produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProjectInfoPageDTO> showProjectDTOSortBy(@PathVariable(name = "sortType", required = true) String sortType){
        return projectService.showAllProjectInfoSortBy(sortType);
    }


    //выводим все проекты с основными  полями черновики, активные
    @PreAuthorize("hasRole('PM')")
    @GetMapping(value = "draftprojects", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProjectInfoPageDTO>  showAllDraftProjects() {
        return projectService.showAllProjectInfoDraft();
    }

    //выводим все проекты с основными полями
    @PreAuthorize("hasRole('PM')")
    @GetMapping(value = "archiveprojects",  produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProjectInfoPageDTO> showArchiveProjectDTO(){
        return projectService.showAllArchiveProjectInfo();
    }

    //фильтрация с использованием FilterCriteria и Specification
   // @PreAuthorize("hasAnyRole('PM', 'HR')")
    @PostMapping(value = "activeprojects/filter",  produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProjectInfoPageDTO> showProjectDTOFilterBy(@RequestBody ProjectInfoPageDTO projectInfoPageDTO){
        return projectService.convertFiltredByCriteria(projectInfoPageDTO.getProjectAuthor(), projectInfoPageDTO.getProj_stage(), projectInfoPageDTO.getCustomer());
    }
}
   // @RequestParam(required = false) String projectAuthor, @RequestParam(required = false) String customer