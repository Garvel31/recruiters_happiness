package ru.ibs.recruiters_happiness.services.interfaces;

import ru.ibs.recruiters_happiness.entities.TeamInfo;

public interface TeamService {
    TeamInfo addTeamInfo (String devMetodology, boolean ProductDev, boolean TeamFormed, int analiticsNumber, int devsNumber, int testerNumber,
                          int techpisNumber, int designerNumber, int frontNumber, int backNumber, int fullstackNumber);
}
