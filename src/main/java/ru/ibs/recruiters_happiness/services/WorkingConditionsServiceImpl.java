package ru.ibs.recruiters_happiness.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.recruiters_happiness.entities.WorkingConditions;
import ru.ibs.recruiters_happiness.repositories.WorkingConditionsRepository;
import ru.ibs.recruiters_happiness.services.interfaces.WorkingConditionsService;

@Service
public class WorkingConditionsServiceImpl implements WorkingConditionsService {

    @Autowired
    WorkingConditionsRepository workingConditionsRepository;

    @Override
    public WorkingConditions addWorkingConditions(boolean isInOffice, boolean isTimeLag, boolean isOverTimeExpect, int timeLag, String procedure) {

        final WorkingConditions workingConditions = new WorkingConditions(isInOffice, isTimeLag, isOverTimeExpect, timeLag, procedure);

        return workingConditionsRepository.save(workingConditions);
    }
}
