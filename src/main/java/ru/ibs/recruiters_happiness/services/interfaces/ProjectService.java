package ru.ibs.recruiters_happiness.services.interfaces;

import ru.ibs.recruiters_happiness.entities.*;

import java.util.LinkedList;
import java.util.List;

public interface ProjectService {
    Project addProject (String project_name, String customer, String proj_stage, boolean gost_doc, String end_terms, String func_direction, String subject_area,
                        String description, String problem_to_solve, String projectAuthor, int stakeholder_number, String technology
                        , TeamInfo teamInfo, ProjectType projectType, WorkingConditions workingConditions);
}
