package ru.ibs.recruiters_happiness.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.recruiters_happiness.configuration.MapperUtil;
import ru.ibs.recruiters_happiness.entities.Project;
import ru.ibs.recruiters_happiness.entities.ProjectType;
import ru.ibs.recruiters_happiness.entities.TeamInfo;
import ru.ibs.recruiters_happiness.entities.dto.ProjectDTO;
import ru.ibs.recruiters_happiness.repositories.ProjectRepository;
import ru.ibs.recruiters_happiness.repositories.TeamInfoRepository;
import ru.ibs.recruiters_happiness.services.interfaces.TeamService;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    TeamInfoRepository teamInfoRepository;
    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public TeamInfo addTeamInfo(String devMetodology, boolean ProductDev, boolean TeamFormed, int analiticsNumber, int devsNumber, int testerNumber,
                                int techpisNumber, int designerNumber, int frontNumber, int backNumber, int fullstackNumber) {
      //  final int allTeamNumber = analiticsNumber + devsNumber + testerNumber + techpisNumber + designerNumber + frontNumber + backNumber + fullstackNumber;
        final TeamInfo teamInfo = new TeamInfo(devMetodology, ProductDev, TeamFormed, analiticsNumber, devsNumber, testerNumber,
                techpisNumber, designerNumber, frontNumber, backNumber, fullstackNumber);
        teamInfo.setAllTeamNumber(fullstackNumber + backNumber + frontNumber + designerNumber + techpisNumber + testerNumber + devsNumber + analiticsNumber);
        return teamInfoRepository.save(teamInfo);
    }

    public void updateTeamInfo(Long projectid, ProjectDTO projectDTO) {
        Project project = MapperUtil.DtoToEntityConv(projectDTO, modelMapper);
       // TeamInfo teamInfo = teamInfoRepository.findTeamInfoByProjectId(projectid);
        TeamInfo teamInfo = teamInfoRepository.findTeamInfoById(projectRepository.findProjectById(projectid).getTeamInfo().getId());
        teamInfo.setProductDev(project.getTeamInfo().isProductDev());
        teamInfo.setTeamFormed(project.getTeamInfo().isTeamFormed());
        teamInfo.setAnaliticsNumber(project.getTeamInfo().getAnaliticsNumber());
        teamInfo.setDevsNumber(project.getTeamInfo().getDevsNumber());
        teamInfo.setTesterNumber(project.getTeamInfo().getTesterNumber());
        teamInfo.setTechpisNumber(project.getTeamInfo().getTechpisNumber());
        teamInfo.setDesignerNumber(project.getTeamInfo().getDesignerNumber());
        teamInfo.setFrontNumber(project.getTeamInfo().getFrontNumber());
        teamInfo.setBackNumber(project.getTeamInfo().getBackNumber());
        teamInfo.setFullstackNumber(project.getTeamInfo().getFullstackNumber());
        teamInfo.setAllTeamNumber(project.getTeamInfo().getAnaliticsNumber()
        + project.getTeamInfo().getDevsNumber() + project.getTeamInfo().getTesterNumber() + project.getTeamInfo().getTechpisNumber());

        teamInfoRepository.save(teamInfo);
    }


}
