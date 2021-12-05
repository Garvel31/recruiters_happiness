package ru.ibs.recruiters_happiness.services;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.recruiters_happiness.configuration.MapperUtil;
import ru.ibs.recruiters_happiness.entities.Technology;
import ru.ibs.recruiters_happiness.entities.dto.ProjectDTO;
import ru.ibs.recruiters_happiness.entities.dto.TechnologyDTO;
import ru.ibs.recruiters_happiness.repositories.TechnologyRepository;
import ru.ibs.recruiters_happiness.services.interfaces.DictionaryService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class TechnologyDictServiceImpl implements DictionaryService {

    @Autowired
    TechnologyRepository technologyRepository;

    @Autowired
    MapperUtil mapperUtil;
    @Autowired
    ModelMapper modelMapper;

    public Technology addTechnology(String tech) {
        Technology technology = new Technology(tech);
        return technologyRepository.save(technology);
    }

    public void parseToDict(String tech) {
        if (tech != null) {
            List<String> techs = List.of(tech.split(", +|,+|\\s+"));
            techs.forEach(s -> {
                try {
                    technologyRepository.save(new Technology(s));
                } catch (Exception ignored) {
                }
            });
        }
    }


    public List<String> dictLinkedList() {
        ArrayList<String> list = new ArrayList<>();
        technologyRepository.findAll().forEach(technology -> list.add(technology.getTech()));

        return list;
    }

//    public List<TechnologyDTO> dictLinkedList() {
//        return MapperUtil.convertList(technologyRepository.findAll(), this::entityToTechDtoConv);
//
//    }

//    public List<Technology> dictLinkedList() {
//        //ArrayList<String> list = new ArrayList<>();
//
//        return (List<Technology>) technologyRepository.findAll();
//    }

//    public TechnologyDTO entityToTechDtoConv(Technology technology) {
//        return modelMapper.map(technology, TechnologyDTO.class);
//    }
//
//    public TechnologyDTO dictLinkedList() {
//        ModelMapper mapper = new ModelMapper();
//
//        mapper.typeMap(Technology.class, TechnologyDTO.class)
//                .addMappings(m -> m.map(
//                        source -> source.getTech(),
//                        (TechnologyDTO destination, String value) -> destination.getTech().add(value)));
//
//    return mapper.map(technologyRepository.findAll(), TechnologyDTO.class);
//    }
}
