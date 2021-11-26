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
    public TeamInfo addTeamInfo(String devMetodology, boolean ProductDev, boolean TeamFormed, int analiticsNumber, int devsNumber, int testerNumber,
                                int techpisNumber, int designerNumber, int frontNumber, int backNumber, int fullstackNumber) {
        final int allTeamNumber = analiticsNumber + devsNumber + testerNumber + techpisNumber + designerNumber + frontNumber + backNumber + fullstackNumber;
        final TeamInfo teamInfo = new TeamInfo(devMetodology, ProductDev, TeamFormed, analiticsNumber, devsNumber, testerNumber,
                techpisNumber, designerNumber, frontNumber, backNumber, fullstackNumber, allTeamNumber);

        return teamInfoRepository.save(teamInfo);
    }

    public void updateTeamInfo(Long projectid, ProjectDTO projectDTO) {
        Project project = MapperUtil.DtoToEntityConv(projectDTO, modelMapper);
        TeamInfo teamInfo = teamInfoRepository.findTeamInfoByProjectId(projectid);
        teamInfo.setProductDev(project.getTeamInfo().isProductDev());
        teamInfo.setTeamFormed(project.getTeamInfo().isTeamFormed());
        teamInfo.setAnaliticsNumber(project.getTeamInfo().getAnaliticsNumber());
        teamInfo.setDevsNumber(project.getTeamInfo().getDevsNumber());
        teamInfo.setTesterNumber(project.getTeamInfo().getTesterNumber());
        teamInfo.setTechpisNumber(project.getTeamInfo().getTechpisNumber());
        //teamInfo.setAllTeamCount(project.getTeamInfo().getAllTeamCount());

        teamInfoRepository.save(teamInfo);
    }
}
