package ru.ibs.recruiters_happiness.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.ibs.recruiters_happiness.entities.ProjectType;

public interface ProjectTypeRepository extends CrudRepository<ProjectType, Long> {

  //  ProjectType findProjectTypeByProjectId(Long projectid);

    ProjectType findProjectTypeById(Long projectTypeid);
}
