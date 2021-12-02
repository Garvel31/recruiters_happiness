package ru.ibs.recruiters_happiness.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.ibs.recruiters_happiness.entities.TeamInfo;

public interface TeamInfoRepository extends CrudRepository<TeamInfo, Long> {

   // TeamInfo findTeamInfoByProjectId(Long projId);

    TeamInfo findTeamInfoById(Long id);
}
