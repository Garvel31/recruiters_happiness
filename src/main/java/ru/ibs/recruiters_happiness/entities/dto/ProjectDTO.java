package ru.ibs.recruiters_happiness.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import ru.ibs.recruiters_happiness.entities.ProjectType;
import ru.ibs.recruiters_happiness.entities.TeamInfo;
import ru.ibs.recruiters_happiness.entities.Technology;
import ru.ibs.recruiters_happiness.entities.WorkingConditions;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {


    @NotNull
    private String project_name;

    @NotNull
    private String proj_stage;


    private boolean gost_doc;

    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String end_terms;


    private String func_direction, subject_area, description, problem_to_solve, projectAuthor, projectCardStats;
    private int stakeholder_number;


    private List<Technology> technology;

    private TeamInfo teamInfo;
    private ProjectType projectType;
    private WorkingConditions workingConditions;

}
