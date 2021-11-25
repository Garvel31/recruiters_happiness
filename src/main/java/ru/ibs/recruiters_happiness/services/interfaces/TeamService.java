package ru.ibs.recruiters_happiness.services.interfaces;

import ru.ibs.recruiters_happiness.entities.TeamInfo;

public interface TeamService {
    TeamInfo addTeamInfo (String devMetodology, boolean isProductDev, boolean isTeamFormed, int analiticsCount, int devsCount, int testerCount,
                          int techpisCount, int allTeamCount);
}
