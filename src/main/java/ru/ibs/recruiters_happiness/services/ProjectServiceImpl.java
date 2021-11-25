package ru.ibs.recruiters_happiness.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.ibs.recruiters_happiness.configuration.MapperUtil;
import ru.ibs.recruiters_happiness.entities.*;
import ru.ibs.recruiters_happiness.entities.dto.ProjectDTO;
import ru.ibs.recruiters_happiness.entities.dto.ProjectInfoPageDTO;
import ru.ibs.recruiters_happiness.repositories.ProjectRepository;
import ru.ibs.recruiters_happiness.services.interfaces.ProjectService;

import java.util.LinkedList;
import java.util.List;


@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ModelMapper modelMapper;

//    @Autowired
//    TechnologyServiceImpl technologyService;


    @Override
    public Project addProject(ProjectDTO projectDTO) {

        final Project newProject = MapperUtil.DtoToEntityConv(projectDTO, modelMapper);
        newProject.getTeamInfo().setProject(newProject);
        newProject.getProjectType().setProject(newProject);
        newProject.getWorkingConditions().setProject(newProject);
////        technologyList.forEach(technology -> {
////            technology.setProject(newProject);
////            newProject.getTechnology().add(technology);
////        });
        return projectRepository.save(newProject);
    }


    public Project updateProject(Long id, ProjectDTO projectDTO) {
        Project project = MapperUtil.DtoToEntityConv(projectDTO, modelMapper);
        Project newProject = projectRepository.findProjectById(id);
        newProject.setProject_name(project.getProject_name());
        newProject.setCustomer(project.getCustomer());
        newProject.setProj_stage(project.getProj_stage());
        newProject.setGost_doc(project.isGost_doc());
        newProject.setEnd_terms(project.getEnd_terms());
        newProject.setFunc_direction(project.getFunc_direction());
        newProject.setSubject_area(project.getSubject_area());
        newProject.setDescription(project.getDescription());
        newProject.setProblem_to_solve(project.getProblem_to_solve());
        newProject.setProjectAuthor(project.getProjectAuthor());
        newProject.setStakeholder_number(project.getStakeholder_number());
        newProject.setTechnology(project.getTechnology());

        return projectRepository.save(newProject);
    }


    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    //показываем карточку по id
    public ProjectDTO showProjectById(Long id) {
        return MapperUtil.entityToDtoConv(projectRepository.findProjectById(id), modelMapper);
    }

    //показываем все ракточки проектов
    public List<ProjectDTO> showAllProject() {
        return MapperUtil.convertList(projectRepository.findAll(), this::entityToProjDtoConv);
    }

    //показываем все карточи в сокращенном формате
    public List<ProjectInfoPageDTO> showAllProjectInfo() {
        return MapperUtil.convertList(projectRepository.findAll(), this::entityToAllProjDtoConv);
    }

    //показываем все карточи в сокращенном формате
    public List<ProjectInfoPageDTO> showAllProjectInfoSortBy(String sortType) {
        return MapperUtil.convertList(SortBy(sortType), this::entityToAllProjDtoConv);
    }
    //показы
    // ваем все карточи в сокращенном формате
    public List<ProjectInfoPageDTO> showAllProjectInfoFilteredByCustomer(String customer) {
        return MapperUtil.convertList(FilterByCustomer(customer), this::entityToAllProjDtoConv);
    }


    //метод для сортировки
    public List<Project> SortBy(String sortType) {
        return projectRepository.findAll(Sort.by(Sort.Direction.ASC, sortType));
    }

    //метод для сортировки
    public List<Project> FilterByCustomer(String customer) {
        return projectRepository.findAllByCustomer(customer);
    }


    //метод для мапинга
    private ProjectDTO entityToProjDtoConv(Project project) {
        return modelMapper.map(project, ProjectDTO.class);
    }

    //метод для мапинга всех карточек проекта в ДТО который передает только основные поля
    private ProjectInfoPageDTO entityToAllProjDtoConv(Project project) {
        return modelMapper.map(project, ProjectInfoPageDTO.class);
    }

}
