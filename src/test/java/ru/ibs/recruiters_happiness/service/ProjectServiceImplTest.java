//package ru.ibs.recruiters_happiness.service;
//
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import ru.ibs.recruiters_happiness.configuration.MapperUtil;
//import ru.ibs.recruiters_happiness.entities.Project;
//import ru.ibs.recruiters_happiness.entities.ProjectType;
//import ru.ibs.recruiters_happiness.entities.TeamInfo;
//import ru.ibs.recruiters_happiness.entities.WorkingConditions;
//import ru.ibs.recruiters_happiness.entities.dto.ProjectDTO;
//import ru.ibs.recruiters_happiness.repositories.ProjectRepository;
//import ru.ibs.recruiters_happiness.services.ProjectServiceImpl;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//@ExtendWith(MockitoExtension.class)
//public class ProjectServiceImplTest {
//
//    @Autowired
//    ProjectServiceImpl service;
//
//    @Autowired
//    ModelMapper modelMapper;
//
//    @MockBean
//    ProjectRepository dao;
//
//    @BeforeEach
//    public void init() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void testAddProject() {
//        TeamInfo teamInfo = new TeamInfo();
//        WorkingConditions workingConditions = new WorkingConditions();
//        ProjectType projectType = new ProjectType();
//        LocalDateTime created = LocalDateTime.now();
//        LocalDateTime updated = LocalDateTime.now();
//        final ProjectDTO projectDTO = new ProjectDTO(1L, "prject name", "customer", "stage", true, "2021-12-01 00:52:05.860462",
//                created, updated, "func_direction", "subject_area", "description",
//                "problem_to_solve", "projectAuthor", "technology", 4,
//                true, true, teamInfo, projectType, workingConditions);
//        final Project newProject = MapperUtil.DtoToEntityConv(projectDTO, modelMapper);
//        service.addProject(projectDTO);
//
//        verify(dao, times(1)).save(newProject);
//    }
//
//    @Test
//    public void testUpdateProject() {
//        TeamInfo teamInfo = new TeamInfo();
//        WorkingConditions workingConditions = new WorkingConditions();
//        ProjectType projectType = new ProjectType();
//        LocalDateTime created = LocalDateTime.now();
//        LocalDateTime updated = LocalDateTime.now();
//        final ProjectDTO projectDTO = new ProjectDTO(1L, "prject name", "other customer", "stage", true, "2021-12-01 00:52:05.860462",
//                created, updated, "func_direction", "subject_area", "description",
//                "problem_to_solve", "projectAuthor", "technology", 4,
//                true, true, teamInfo, projectType, workingConditions);
//        final Project newProject = MapperUtil.DtoToEntityConv(projectDTO, modelMapper);
//        Project project = new Project(1L, created, updated, "prject name", "customer", "stage", true, true, true, "2021-12-01 00:52:05.860462"
//                , "func_direction", "subject_area", "description",
//                "problem_to_solve", "projectAuthor", "technology", 4
//                , teamInfo, projectType, workingConditions);
//
//        when(dao.findProjectById(1L)).thenReturn(project);
//        when(dao.save(newProject)).thenReturn(newProject);
//        service.updateProject(1L, projectDTO);
//        verify(dao, times(1)).save(newProject); //проверили что сохраняет
//        assertEquals(newProject.getCustomer(), projectDTO.getCustomer()); //проверили что смапили правильно
//    }
//
////    @Test todo пишет что нет метода deletebyid
////    public void testDeleteProject() {
////        TeamInfo teamInfo = new TeamInfo();
////        WorkingConditions workingConditions = new WorkingConditions();
////        ProjectType projectType = new ProjectType();
////        LocalDateTime created = LocalDateTime.now();
////        LocalDateTime updated = LocalDateTime.now();
////        Project project = new Project(1L, created, updated, "prject name", "customer", "stage", true, true, true, "2021-12-01 00:52:05.860462"
////                , "func_direction", "subject_area", "description",
////                "problem_to_solve", "projectAuthor", "technology", 4
////                , teamInfo, projectType, workingConditions);
////        List<Project> list = new ArrayList<Project>();
////        list.add(project);
////        when(dao.deleteById()).thenReturn(null);
////        service.deleteProject(1L);
////        assertEquals(Optional.empty(), dao.findById(1L));
////    }
//
//
//    @Test
//    public void testMoveProjectToArchive() {
//        TeamInfo teamInfo = new TeamInfo();
//        WorkingConditions workingConditions = new WorkingConditions();
//        ProjectType projectType = new ProjectType();
//        LocalDateTime created = LocalDateTime.now();
//        LocalDateTime updated = LocalDateTime.now();
//        Project project = new Project(1L, created, updated, "prject name", "customer", "stage", true, true, true, "2021-12-01 00:52:05.860462"
//                , "func_direction", "subject_area", "description",
//                "problem_to_solve", "projectAuthor", "technology", 4
//                , teamInfo, projectType, workingConditions);
//        when(dao.findProjectById(1L)).thenReturn(project);
//
//        service.moveProjectToArchive(1L);
//        assertEquals(false, project.isActive());
//    }
//
//    @Test
//    public void testShowProjectById() {
//        TeamInfo teamInfo = new TeamInfo();
//        WorkingConditions workingConditions = new WorkingConditions();
//        ProjectType projectType = new ProjectType();
//        LocalDateTime created = LocalDateTime.now();
//        LocalDateTime updated = LocalDateTime.now();
//        Project project = new Project(1L, created, updated, "prject name", "customer", "stage", true, true, true, "2021-12-01 00:52:05.860462"
//                , "func_direction", "subject_area", "description",
//                "problem_to_solve", "projectAuthor", "technology", 4
//                , teamInfo, projectType, workingConditions);
//        when(dao.findProjectById(1L)).thenReturn(project);
//
//
//        assertEquals(project.getProject_name(), service.showProjectById(1L).getProject_name());
//        verify(dao, times(1)).findProjectById(1L);
//    }
//
//    @Test
//    public void testShowAllProject() {
//        Project project1 = new Project();
//        Project project2 = new Project();
//        List<Project> projectList = new LinkedList<>();
//        projectList.add(project1);
//        projectList.add(project2);
//        when(dao.findAll()).thenReturn(projectList);
//        List<ProjectDTO> newProjectList = service.showAllProject();
//        assertEquals(2, newProjectList.size());
//        verify(dao, times(1)).findAll();
//    }
//
//
//
//}
