package ru.ibs.recruiters_happiness.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.ibs.recruiters_happiness.entities.Project;
import ru.ibs.recruiters_happiness.entities.Technology;

import java.util.List;

public interface TechnologyRepository extends CrudRepository<Technology, Long> {

    List<Technology> findAll();

}
