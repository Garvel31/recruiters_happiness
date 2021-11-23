package ru.ibs.recruiters_happiness.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.recruiters_happiness.entities.TeamInfo;
import ru.ibs.recruiters_happiness.repositories.TeamInfoRepository;
import ru.ibs.recruiters_happiness.services.interfaces.TeamService;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    TeamInfoRepository teamInfoRepository;

    @Override
    public TeamInfo addTeamInfo(String devMetodology, boolean isProductDev, boolean isTeamFormed, int analiticsCount,
                                int devsCount, int testerCount, int techpisCount, int allTeamCount) {

        final TeamInfo teamInfo = new TeamInfo( devMetodology,  isProductDev,  isTeamFormed,  analiticsCount,
         devsCount,  testerCount,  techpisCount,  allTeamCount);

        return teamInfoRepository.save(teamInfo);
    }
}
