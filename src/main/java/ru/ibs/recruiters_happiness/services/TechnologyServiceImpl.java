package ru.ibs.recruiters_happiness.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.recruiters_happiness.entities.Technology;
import ru.ibs.recruiters_happiness.repositories.TechnologyRepository;
import ru.ibs.recruiters_happiness.services.interfaces.DictionaryService;

import java.util.ArrayList;
import java.util.List;

@Service
public class TechnologyServiceImpl implements DictionaryService {

    @Autowired
    TechnologyRepository technologyRepository;

    public Technology addTechnology(String tech) {
        Technology technology = new Technology(tech);
        return technologyRepository.save(technology);
    }

    public void parseToDict(String tech) {
        List<String> techs = List.of(tech.split(", "));
        techs.forEach(s -> {
            try {
                technologyRepository.save(new Technology(s));
            } catch (Exception ignored) {
            }
        });
    }

    public List<String> dictLinkedList() {
        ArrayList<String> list = new ArrayList<>();
        technologyRepository.findAll().forEach(technology -> list.add(technology.getTech()));
        return list;
    }

}
