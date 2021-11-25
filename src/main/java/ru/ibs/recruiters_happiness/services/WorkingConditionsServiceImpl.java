package ru.ibs.recruiters_happiness.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.recruiters_happiness.entities.TeamInfo;
import ru.ibs.recruiters_happiness.entities.WorkingConditions;
import ru.ibs.recruiters_happiness.repositories.WorkingConditionsRepository;
import ru.ibs.recruiters_happiness.services.interfaces.WorkingConditionsService;

@Service
public class WorkingConditionsServiceImpl implements WorkingConditionsService {

    @Autowired
    WorkingConditionsRepository workingConditionsRepository;

    @Override
    public WorkingConditions addWorkingConditions(boolean isInOffice, boolean isTimeLag, boolean isOverTimeExpect, int lagOfTime, String procedure) {

        final WorkingConditions workingConditions = new WorkingConditions(isInOffice, isTimeLag, isOverTimeExpect, lagOfTime, procedure);

        return workingConditionsRepository.save(workingConditions);
    }

    public void updateWorkingConditions(Long projectid, boolean isInOffice, boolean isTimeLag, boolean isOverTimeExpect, int lagOfTime, String procedure ) {
        WorkingConditions workingConditions = workingConditionsRepository.findByProjectId(projectid);
        workingConditions.setInOffice(isInOffice);
        workingConditions.setTimeLag(isTimeLag);
        workingConditions.setOverTimeExpect(isOverTimeExpect);
        workingConditions.setLagOfTime(lagOfTime);
        workingConditions.setProcedure(procedure);
        workingConditionsRepository.save(workingConditions);
    }
}
