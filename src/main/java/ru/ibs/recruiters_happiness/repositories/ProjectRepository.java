package ru.ibs.recruiters_happiness.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import ru.ibs.recruiters_happiness.entities.Project;
import ru.ibs.recruiters_happiness.entities.ProjectType;

import java.util.LinkedList;
import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    Project findProjectById(Long id);
    Project findProjectByIdAndActiveIsTrue(Long id);
    List<Project> findAll();
    List<Project> findAllByActiveIsTrue();
    List<Project> findAllByActiveIsFalse();
    Project findAllByOrderByProjectAuthor();
    List<Project> findAllByCustomer(String customer);
    List<Project> findAll(Sort customer);
    Project findProjectByDraftIsTrue();
}
