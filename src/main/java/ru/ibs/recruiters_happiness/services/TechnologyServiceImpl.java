//package ru.ibs.recruiters_happiness.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import ru.ibs.recruiters_happiness.entities.ProjectType;
//import ru.ibs.recruiters_happiness.entities.Technology;
//import ru.ibs.recruiters_happiness.repositories.TechnologyRepository;
//import ru.ibs.recruiters_happiness.services.interfaces.TechnologyService;
//
//import java.util.LinkedList;
//
//@Service
//public class TechnologyServiceImpl implements TechnologyService {
//
//    @Autowired
//    TechnologyRepository technologyRepository;
//
//
//    @Override
//    public Technology addTechnology(String technologyType) {
//       final Technology newTechnology = new Technology(technologyType);
//
//        return technologyRepository.save(newTechnology);
//    }
//
//
//    public void updateTechnology(Long projectid, Technology technology) {
//        Technology technology = technologyRepository.findAllByProjectId(projectid);
//
//        technologyRepository.saveAll(technology);
//
//    }
//}
