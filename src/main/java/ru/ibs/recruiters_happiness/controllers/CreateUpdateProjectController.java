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
@RequestMapping(value = "/hrdream", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
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
    public Object addProject(@RequestBody(required = false) @Valid ProjectDTO body) {
        Project newProject = DtoToEntityConv(body);
//        LinkedList<Technology> technologyLinkedList = new LinkedList<>();
//        technologyLinkedList.addAll(newProject.getTechnology());
        return projectService.addProject(newProject.getProject_name(), newProject.getCustomer(), newProject.getProj_stage(), newProject.isGost_doc(),
                newProject.getEnd_terms(), newProject.getFunc_direction(), newProject.getSubject_area(), newProject.getDescription(),
                newProject.getProblem_to_solve(), newProject.getProjectAuthor(), newProject.getStakeholder_number(),
                newProject.getTechnology(), newProject.getTeamInfo(), newProject.getProjectType(), newProject.getWorkingConditions());
    }

    @PostMapping(value = "update", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateProject(@RequestParam(required = true) Long id, @RequestBody(required = false) @Valid ProjectDTO body) {
        Project newProject = DtoToEntityConv(body);
//        LinkedList<Technology> technologyLinkedList = new LinkedList<>();
//        technologyLinkedList.addAll(newProject.getTechnology());
        projectService.updateProject(id, newProject.getProject_name(), newProject.getCustomer(), newProject.getProj_stage(), newProject.isGost_doc(),
                newProject.getEnd_terms(), newProject.getFunc_direction(), newProject.getSubject_area(), newProject.getDescription(),
                newProject.getProblem_to_solve(), newProject.getProjectAuthor(), newProject.getStakeholder_number(),
                newProject.getTechnology());

        projectTypeService.updateProjectType(id, newProject.getProjectType().isPayType(), newProject.getProjectType().isPO(),
                newProject.getProjectType().isMVP(), newProject.getProjectType().isFromScratch());

        teamService.updateTeamInfo(id, newProject.getTeamInfo().isProductDev(), newProject.getTeamInfo().isTeamFormed(),
                newProject.getTeamInfo().getAnaliticsCount(), newProject.getTeamInfo().getDevsCount(), newProject.getTeamInfo().getTesterCount(),
                newProject.getTeamInfo().getTechpisCount(), newProject.getTeamInfo().getAllTeamCount());

        workingConditionsService.updateWorkingConditions(id, newProject.getWorkingConditions().isInOffice(),
                newProject.getWorkingConditions().isTimeLag(), newProject.getWorkingConditions().isOverTimeExpect(),
                newProject.getWorkingConditions().getLagOfTime(), newProject.getWorkingConditions().getProcedure());

    }

    @PostMapping(value = "delete")
    public void deleteProject(@RequestParam(required = true) Long id) {
        projectService.deleteProject(id);
    }

    @GetMapping("allprojects")
    private List<ProjectInfoPageDTO> readDTOCard(){
        List<Project> tables = projectService.showAllProject();
        return MapperUtil.convertList(tables, this::entityToAllProjDtoConv);
    }

    @GetMapping("allprojects/sort/bycustomer")
    private List<ProjectInfoPageDTO> readDTOCardSortByCustomer(){
        List<Project> tables = projectService.showAllProjectInfoSortByCustomer();
        return MapperUtil.convertList(tables, this::entityToAllProjDtoConv);
    }

    private ProjectInfoPageDTO entityToAllProjDtoConv(Project project) {
        return modelMapper.map(project, ProjectInfoPageDTO.class);
    }

    private ProjectDTO entityToDtoConv(Project project) {
        return modelMapper.map(project, ProjectDTO.class);
    }

    private Project DtoToEntityConv(ProjectDTO projectDto) {
        return modelMapper.map(projectDto, Project.class);
    }

}
