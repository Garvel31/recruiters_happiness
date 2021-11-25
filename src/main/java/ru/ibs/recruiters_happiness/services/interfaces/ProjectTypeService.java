package ru.ibs.recruiters_happiness.services.interfaces;

import ru.ibs.recruiters_happiness.entities.ProjectType;

public interface ProjectTypeService {

    ProjectType addProjectType(boolean isPayType, boolean isPO, boolean isMVP, boolean isFromScratch);
}
