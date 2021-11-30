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

import static ru.ibs.recruiters_happiness.configuration.ApplicationUserRole.PM;

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


    @PostConstruct
    private void postConstruct() {


        AppUser appUser = new AppUser(PM.name(), "ProductManager", passwordEncoder.encode("12345"), true, true, true, true);
        dbApplicationUserDAO.save(appUser);


    }

    public static void main(String[] args) {
        SpringApplication.run(RecruitersHappinessApplication.class, args);
    }

}
