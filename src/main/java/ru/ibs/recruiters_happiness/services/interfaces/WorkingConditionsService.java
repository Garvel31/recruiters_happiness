package ru.ibs.recruiters_happiness.services.interfaces;

import ru.ibs.recruiters_happiness.entities.WorkingConditions;

public interface WorkingConditionsService {

     WorkingConditions addWorkingConditions(boolean isInOffice, boolean isTimeLag, boolean isOverTimeExpect, String schedule, String procedure, String adress);
}
