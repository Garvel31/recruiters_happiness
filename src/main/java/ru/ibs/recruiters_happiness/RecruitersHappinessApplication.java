package ru.ibs.recruiters_happiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.ibs.recruiters_happiness.auth.db.AppUser;
import ru.ibs.recruiters_happiness.auth.db.DbApplicationUserService;
import ru.ibs.recruiters_happiness.auth.db.DbApplicationUserDAO;

import ru.ibs.recruiters_happiness.services.ProjectServiceImpl;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import javax.annotation.PostConstruct;

import static ru.ibs.recruiters_happiness.configuration.ApplicationUserRole.*;

@SpringBootApplication
@EnableSwagger2
public class RecruitersHappinessApplication {

    @Autowired
    ProjectServiceImpl projectService;

    @Autowired
    DbApplicationUserService applicationUserService;
    @Autowired
    DbApplicationUserDAO dbApplicationUserDAO;
    @Autowired
    PasswordEncoder passwordEncoder;

//    @Autowired
//    TechnologyServiceImpl technologyService;
//
//    @Autowired
//    TechnologyRepository technologyRepository;


//    @PostConstruct
//    private void postConstruct() {
//        dbApplicationUserDAO.deleteAll();
//        AppUser appUser = new AppUser(PM.name(), "ProductManager", "12345", true, true, true, true);
//        dbApplicationUserDAO.save(appUser);
//        AppUser appUser1 = new AppUser(HR.name(),  "HeadRecruiter", "12345", true, true, true, true);
//        dbApplicationUserDAO.save(appUser1);
//        AppUser appUser2 = new AppUser(DM.name(), "DevManager", "12345", true, true, true, true);
//        dbApplicationUserDAO.save(appUser2);
//
//    }

    public static void main(String[] args) {
        SpringApplication.run(RecruitersHappinessApplication.class, args);
    }

}


//todo unit test
//todo docker file
//todo справочник для объектной области

