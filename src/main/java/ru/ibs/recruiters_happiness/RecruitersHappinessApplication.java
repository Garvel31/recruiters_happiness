package ru.ibs.recruiters_happiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.ibs.recruiters_happiness.entities.ProjectType;
import ru.ibs.recruiters_happiness.entities.TeamInfo;
import ru.ibs.recruiters_happiness.entities.Technology;
import ru.ibs.recruiters_happiness.entities.WorkingConditions;
import ru.ibs.recruiters_happiness.repositories.TechnologyRepository;
import ru.ibs.recruiters_happiness.services.ProjectServiceImpl;
import ru.ibs.recruiters_happiness.services.TechnologyServiceImpl;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
public class RecruitersHappinessApplication {

    @Autowired
    ProjectServiceImpl projectService;

    @Autowired
    TechnologyServiceImpl technologyService;

    @Autowired
    TechnologyRepository technologyRepository;


    @PostConstruct
    private void postConstruct(){

//        Technology newTech1 = new Technology("Spring");
//        Technology newTech2 = new Technology("Java");
////        Technology newTech3 = new Technology("Python");
////        Technology newTech4 = new Technology("SQL");
//        LinkedList<Technology> technologyList = new LinkedList<>();
//        technologyList.add(newTech1);
//        technologyList.add(newTech2);
////        LinkedList<Technology> technologyList2 =  new LinkedList<>();
////        technologyList2.add(newTech3);
////        technologyList2.add(newTech4);
//        TeamInfo teamInfo = new TeamInfo("agile", true, true, 3,4,5,6,2);
//        ProjectType projectType = new ProjectType(true,true,true,true);
//        WorkingConditions workingConditions = new WorkingConditions(true,true,true,2,"some procedure");
//        projectService.addProject("Gazprom", "from zero", true, "14-04-2022", technologyList, teamInfo, projectType, workingConditions);
////        projectService.addProject("IBS", "from zero", false, "17-07-2024", technologyList2);
    }

    public static void main(String[] args) {
        SpringApplication.run(RecruitersHappinessApplication.class, args);
    }

}
