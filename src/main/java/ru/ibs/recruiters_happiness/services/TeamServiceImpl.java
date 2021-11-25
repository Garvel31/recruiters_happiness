package ru.ibs.recruiters_happiness.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.recruiters_happiness.entities.ProjectType;
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

    public void updateTeamInfo(Long projectid, boolean isProductDev, boolean isTeamFormed, int analiticsCount,
                                   int devsCount, int testerCount, int techpisCount, int allTeamCount) {
        TeamInfo teamInfo = teamInfoRepository.findTeamInfoByProjectId(projectid);
        teamInfo.setProductDev(isProductDev);
        teamInfo.setTeamFormed(isTeamFormed);
        teamInfo.setAnaliticsCount(analiticsCount);
        teamInfo.setDevsCount(devsCount);
        teamInfo.setTesterCount(testerCount);
        teamInfo.setTechpisCount(techpisCount);
        teamInfo.setAllTeamCount(allTeamCount);

        teamInfoRepository.save(teamInfo);
    }
}
