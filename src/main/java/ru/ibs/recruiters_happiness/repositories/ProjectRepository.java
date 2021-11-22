package ru.ibs.recruiters_happiness.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.ibs.recruiters_happiness.entities.Project;

import java.util.LinkedList;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    Project findProjectById(Long id);
    LinkedList<Project> findAll();
}
