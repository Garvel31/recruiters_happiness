package ru.ibs.recruiters_happiness.services.interfaces;

import ru.ibs.recruiters_happiness.entities.Project;
import ru.ibs.recruiters_happiness.entities.Technology;

import java.util.LinkedList;
import java.util.List;

public interface ProjectService {
    Project addProject (String project_name, String proj_stage, boolean gost_doc, String end_terms, LinkedList<Technology> technologyList);
}
