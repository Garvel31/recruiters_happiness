//package ru.ibs.recruiters_happiness;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultMatcher;
//import ru.ibs.recruiters_happiness.configuration.MapperUtil;
//import ru.ibs.recruiters_happiness.controllers.AllProjectsInfoController;
//import ru.ibs.recruiters_happiness.entities.Project;
//import ru.ibs.recruiters_happiness.entities.dto.ProjectDTO;
//import ru.ibs.recruiters_happiness.entities.dto.ProjectInfoPageDTO;
//import ru.ibs.recruiters_happiness.services.ProjectServiceImpl;
//
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.List;
//
//import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
//import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(AllProjectsInfoController.class)
//public class AllProjectsInfoControllerIntegrationTest {
//
//    @Autowired
//    private MockMvc mvc;
//    @InjectMocks
//    ModelMapper modelMapper;
//
//    @MockBean
//    private ProjectServiceImpl service;
//
//    @MockBean
//    MapperUtil mapperUtil;
//
//    @Test
//    public void givenEmployees_whenGetEmployees_thenReturnJsonArray()
//            throws Exception {
//
//        Project project = new Project();
//        project.setCustomer("Customer");
//        List<Project> projectList = new LinkedList<>();
//        projectList.add(project);
//        List<ProjectInfoPageDTO> allProjectDto = MapperUtil.convertList(projectList, this::entityToAllProjDtoConv);
//
//        given(service.showAllProjectInfo()).willReturn(allProjectDto);
//
//        mvc.perform(get("/hrdream/projectlist/activeprojects")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(1)))
//                .andExpect((ResultMatcher) jsonPath("$[0].customer", is(project.getCustomer())));
//    }
//    private ProjectInfoPageDTO entityToAllProjDtoConv(Project project) {
//        return modelMapper.map(project, ProjectInfoPageDTO.class);
//    }
//
//}