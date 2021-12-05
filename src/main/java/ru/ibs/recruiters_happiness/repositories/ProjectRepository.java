package ru.ibs.recruiters_happiness.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import ru.ibs.recruiters_happiness.entities.Project;
import ru.ibs.recruiters_happiness.entities.ProjectType;

import java.util.LinkedList;
import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long>, JpaSpecificationExecutor<Project> {

    Project findProjectById(Long id);

    Project findProjectByIdAndActiveIsTrue(Long id);
    List<Project> findAll();
    List<Project> findAllByActiveIsTrue(Sort customer);
  //  List<Project> findAllByActiveIsTrue();
    List<Project> findAllByActiveIsTrueAndDraftIsFalse();
    List<Project> findAllByActiveIsFalse();
    List<Project> findAllByDraftIsTrueAndActiveIsTrue();
    List<Project> findAllByDraftIsFalse();
    Project findAllByOrderByProjectAuthor();
    List<Project> findAllByCustomer(String customer);
    List<Project> findAll(Sort customer);
    Project findProjectByDraftIsTrue();
    List<Project> findAll(Specification<Project> projectSpecification);


}
