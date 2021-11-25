package ru.ibs.recruiters_happiness.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.recruiters_happiness.configuration.MapperUtil;
import ru.ibs.recruiters_happiness.entities.Project;
import ru.ibs.recruiters_happiness.entities.ProjectType;
import ru.ibs.recruiters_happiness.entities.TeamInfo;
import ru.ibs.recruiters_happiness.entities.dto.ProjectDTO;
import ru.ibs.recruiters_happiness.repositories.TeamInfoRepository;
import ru.ibs.recruiters_happiness.services.interfaces.TeamService;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    TeamInfoRepository teamInfoRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public TeamInfo addTeamInfo(String devMetodology, boolean isProductDev, boolean isTeamFormed, int analiticsCount,
                                int devsCount, int testerCount, int techpisCount, int allTeamCount) {

        final TeamInfo teamInfo = new TeamInfo( devMetodology,  isProductDev,  isTeamFormed,  analiticsCount,
         devsCount,  testerCount,  techpisCount,  allTeamCount);

        return teamInfoRepository.save(teamInfo);
    }

    public void updateTeamInfo(Long projectid, ProjectDTO projectDTO) {
        Project project = MapperUtil.DtoToEntityConv(projectDTO, modelMapper);
        TeamInfo teamInfo = teamInfoRepository.findTeamInfoByProjectId(projectid);
        teamInfo.setProductDev(project.getTeamInfo().isProductDev());
        teamInfo.setTeamFormed(project.getTeamInfo().isTeamFormed());
        teamInfo.setAnaliticsCount(project.getTeamInfo().getAnaliticsCount());
        teamInfo.setDevsCount(project.getTeamInfo().getDevsCount());
        teamInfo.setTesterCount(project.getTeamInfo().getTesterCount());
        teamInfo.setTechpisCount(project.getTeamInfo().getTechpisCount());
        teamInfo.setAllTeamCount(project.getTeamInfo().getAllTeamCount());

        teamInfoRepository.save(teamInfo);
    }
}
